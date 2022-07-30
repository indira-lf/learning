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

# String Table的垃圾回收



# G1中的String去重操作

