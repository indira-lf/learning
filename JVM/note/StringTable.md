# String的基本特性

- 用""引起来用；
- 声明为final的，不可被继承；
- 实现了Serializable接口；
- 实现了Comparable接口；

# String的内存分配

String类型的常量池比较特殊，它的主要使用方法有两种：

- 直接使用双引号声明出来的String对象会直接存储在常量池中。
- 如果不是用双引号声明的String对象，可以使用String提供的intern()方法。

Java8元空间，字符串常量在堆中。

# String的基本操作



# 字符串拼接操作

- 常量与常量的拼接结果在常量池，原理是编译期优化
- 常量池中不会存在相同内容的常量
- 只要其中有一个变量，结果就在堆中。变量拼接的原理是StringBuilder
- 如果拼接的结果调用intern()方法，则主动将常量池中还没有的字符串对象放入池中，并返回此对象地址。

# intern()的使用

intern()方法会从常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中，

```java
String myInfo = new String("aaaaa").intern();
```

也就是说，如果在任意字符串上调用String.intern()方法，那么返回结果所指向的那个类实例，必须和直接以常量形式出现的字符串实例完全相同。因此，下来表达式比必定是true

```java
("a"+"b"+"c").intern() == "abc";
```

通俗点讲，Interned String就是确保字符串在内存里只有一份拷贝，这样可以节约内存空间，加快字符串操作任务和执行速度。

注意：这个值会被存放在字符串内部池（String Intern Pool）。



## new String("ab");会创建几个对象

两个

一个对象是：new关键字在堆空间创建的

另一个对象是：字符串常量池中的对象；字节码指令ldc

## new String("a")+new String("b");会创建几个对象

```java
    @Test
    public void test9(){
        /**
         * 对象1：new StringBuilder()
         * 对象2：new String("a")
         * 对象3：常量池中的"a"
         * 对象4：new String("b")
         * 对象5：常量池中的"b"
         * 
         * 深入剖析：StringBuilder的toString()
         *  对象6：new String("ab");
         *      toString()的调用在字符串常量池中，没有生成"ab"
         */
        String str = new String("a") + new String("b");
    }
```



## 总结：在JDK6和JDK7/8中的使用

- JDK6中，将这个字符串尝试放入字符串常量池中。
- - 如果常量池中有，则并不会放入。返回已有的串池中的对象的地址
  - 如果没有，会把==此对象复制一份== ，放入字符串常量池，并返回字符串常量池中的对象地址
- JDK7起，将这个字符串对象尝试放入字符串常量池
- - 如果字符串常量池中有，并不会放入。返回已有的字符串常量池中的对象的地址
  - 如果没有，则会把==对象的引用地址复制一份== ，放入字符串常量池，并返回字符串常量池中的引用地址

# String Table的垃圾回收



# G1中的String去重操作

- java堆中存活的数据集合差不多25%是String对象。
- 堆上存在重复的String对象必然是一种内存的浪费。

实现：

- 当垃圾收集器工作的时候，会访问堆上存活的对象。**对每一个访问的对象都会检查是否候选的要去重的String对象** 。
- 如果是，把这个对象的一个引用插入到队列中等待后续的处理。一个去重的线程在后台运行，处理这个队列。处理队列的一个元素意味着从队列删除这个元素，然后尝试去重它的引用的String对象。
- 使用一个hashtable来记录所有的被String对象使用的不重复的char数组。当去重的时候，会检查这个hashtable，来看堆上是否存在已经存在一个一模一样的char数组。
- 如果存在，String对象会被调整引用那个数组，释放对原来的数组的引用，最终会被垃圾收集器回收掉。
- 如果查找失败，char数组会被插入到hashtable，这样以后的时候就可以共享这个数组了。



命令行：

- UseStringDeduplication(bool):开启String去重，默认是不开启的，需要手动开启。
- PrintStringDeduplicationStatistics(bool)：打印详细的去重统计信息
- StringDeduplicationAgeThreshold(uintx)：达到这个年龄的String对象被认为是去重的候选对象