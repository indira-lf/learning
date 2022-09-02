# 基本概念

## 消息（Message）

消息是指，消息系统所传输信息的物理载体，生产和消费数据的最小单位，每条消息必须属于一个主题。

## 主题（Topic）

Topic表示一类消息的集合，每个主题都包含若干条消息，$\textcolor{red}{每条消息只能属于一个主题} $，是RocketMQ进行消息订阅的基本单位。

一个生成者可以同时发送多种Topic的消息；而一个消费者只对某种特定的Topic感兴趣，即只可以订阅和消费一种Topic的消息。

## 标签（Tag）

为消息设置的标签，用于同一主题下区分不同类型的消息。来自同一业务单元的消息，可以根据不同业务目的在同一主题下设置不同标签。标签能够有效地保证代码的清晰度和连贯性，并优化RocketMQ提供的查询系统。消费者可以根据Tag实现对不同子主题的不同消费逻辑，实现更好的扩展性。

## 队列（Queue）

存储消息的物理实体。一个Topic中可以包含多个Queue，每个Queue中存放的就是该Topic的消息。一个Topic的Queue也被称为一个Topic中消息的分区（Partition）。

一个Topic的Queue中的消息只能被一个消费者组中的一个消费者消费。一个Queue中的消息不允许同一个消费者组中的多个消费者同时消费。

## 消息标识（MessageId/Key）

RocketMQ中每个消息拥有唯一的MessageId，且可以携带具有业务标识的Key，以方便对消息的查询。不过需要注意的是，MessageId有两个：在生产者send()消息时会自动生成一个MessageId（msgId），当消息到达Broker后，Broker也会自动生成一个MessageId(offsetMsgId)。msgId、offsetMsgId与key都称为消息标识。

- msgId：由Producer端生成，其生成规则为：
- - ProductIp + 进程IP + MessageClientIdSetter类的ClassLoader的hashCode + 当前时间 + AutomicInteger
- offsetMsgId：由broker端生成，其生成规则为：brokerIP + 物理分区的offset
- key：由用户指定的业务相关的唯一标识。


# 系统架构

## Producer

消息生成者，负责生产消息。Producer通过MQ的负载均衡模块选择相应的Broker集群队列进行消息投递，投递的过程支持快速失败并且低延迟。

RocketMQ中的消息生产者都是以生产者组的信息出现的。生产者组是同一类生成者的集合，这类Producer发送相同Topic类型的消息。

## Consumer

消息消费者，负责消费消息。一个消息消费者会从Broker服务器中获取到消息，并对消息进行相关业务处理。

RocketMQ中的消息消费者都是以$\textcolor{red}{消费者组}$的形式出现的。消费者组是同一类消费者的集合，这类Consumer消费的是同一个Topic类型的消息。消费者组使得在消息消费方面，实现负载均衡和容错的目标变得非常容易。

> 负载均衡是指Queue的负载均衡，而不是消息的负载均衡
>
> > 将一个Topic中的不同的Queue平均分配给同一个Consumer Group的不同Consumer

消费者组中的Consumer的数量应该小于等于Topic的Queue数量。如果超出Queue数量，则多出的Consumer将不能消费消息。一个Topic类型的消息可以被多个消费者组同时消费。

## Name Server

**功能介绍** 

NameServer是一个Broker与Topic路由的注册中心，支持Broker的动态注册与发现。

主要两个功能：

- $\textcolor{red}{Broker管理}$ ：接受Broker集群的注册信息并且保存下来作为路由信息的基本数据；提供心跳检测机制，检查Broker是否还存活。
- $\textcolor{red}{路由信息管理}$ ：每个NameServer中都保存着Broker集群的整个路由信息和用于客户端查询的队列信息。Producer和Consumer通过NameServer可以获取整个Broker集群的路由信息，从而进行消息的投递和消费。

**路由注册**

NameServer通常也是以集群的方式部署，不过，NameServer是无状态的，即NameServer集群中的各个节点间是无差异的，各个节点间相互不进行消息通讯。那各节点中的数据是如何进行数据同步的呢？在Broker节点启动时，轮训NameServer列表，与每个NameServer节点建立长连接，发起注册请求。在NameServer内部维护着一个Broker列表，用来动态存储Broker的信息。

Broker节点为了证明自己是活着的，为了维护与NameServer间的长连接，会将最新的信息以心跳包的方式上报给NameServer，每30秒发送一次心跳包后，会更新心跳时间戳，记录这个Broker的最新存活时间。

**路由剔除** 

由于Broker关机、宕机或网络抖动等原因，NameServer没有收到Broker的心跳，NameServer可能会将其从Broker列表中剔除。

NameServer中有一个定时任务，每隔10秒就会扫描一次Broker表，查看每一个Broker的最新心跳时间戳距离当前时间是否超过120秒，如果超过，则会判定Broker失效，然后将其从Broker列表中剔除。

**路由发现** 

BroketMQ的路由发现采用的是Pull模型。当Topic路由信息发生变化时，NameServer不会主动推送给客户端，而是客户端定时拉取主题最新的路由。默认客户端每30秒会拉取一次最新的路由。

> Push模型：推送模型。需要维护一个长连接，其实时性较好。
>
> Pull模型：拉取模型。存在的问题是，实时性较差。
>
> Long Polling模型：长轮询模型。其是对Push与Pull模型的整合，充分利用了这两种模型的优势，屏蔽了它们的劣势。

**客户端NameServer选择策略** 

客户端在配置时必须要写上NameServer集群的地址，那么客户端到底连接的是哪个NameServer节点呢？客户端首先会选取一个随机数，然后再与NameServer节点数量取模，此时得到的就是所要连接的节点索引，然后就会进行连接。如果连接失败，则会采用round-robin策略，逐个尝试着去连接其它节点。