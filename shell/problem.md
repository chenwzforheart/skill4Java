## 1.volatile原理
- 答：禁止变量缓存到CPU CACHE，读取时从主内存读取，对所有线程可见。写入时会加入屏障，禁止指令重排序

## 2.HashMap扩容问题，哪些操作导致扩容
- 当前数据存储的数量（即size()）大小必须大于等于阈值；当前加入的数据是否发生了hash冲突。
- putVal，putMapEntries

## 3.JAVA容器
- 并发：Concurrent(5),CopyOnWrite(2)
- 同步：Vector、Stack、HashTable。Collections.synchronizedXX()
- BlockingQueue（3），Deque（1）,Queue（3）

## 4.反射原理，注解原理
- 编译时类型信息已知，运行时通过检查类的类型信息匹配CLASS对象
- 通过反射获取注解原信息，@Retention(RetentionPolicy.RUNTIME)

## 5.类的加载过程
- 加载->链接（验证，准备，解析）->初始化
- 使用->卸载
- 双亲机制：尝试加载类时会先请求双亲，请求失败则会自己加载
- ![类加载过程](./类加载-0.png)
- ![类加载过程](./类加载-1.png)

## 6.JVM内存模型
- ![内存模型图](./JVM内存模型.png)
- ![方法区示意图](./方法区示意图.png)

## 7.树结构解析
- [二叉平衡树，B+树](https://blog.csdn.net/u011240877/article/details/80490663)
- [B+树，B*树](https://blog.csdn.net/pengzhisen123/article/details/79927377)

## 8.JVM调优工具
- [JVM监控](https://blog.csdn.net/xybelieve1990/article/details/53516437)
- jvisualvm，jps，jinfo。查看和调整虚拟机参数
- jmap，jhat。生成heap dump文件
 还阔以使用-XX:+HeapDumpOnOutOfMemoryError参数来让虚拟机出现OOM的时候·自动生成dump文件。
- jstat。查看JVM运行时状态信息的命令
- jstack。查看线程快照

        NEW,未启动的。不会出现在Dump中。
        
        RUNNABLE,在虚拟机内执行的。
        
        BLOCKED,受阻塞并等待监视器锁。
        
        WATING,无限期等待另一个线程执行特定操作。
        
        TIMED_WATING,有时限的等待另一个线程的特定操作。
        
        TERMINATED,已退出的。

 - ![线程状态示意图](./线程状态图.jpg)
 
## 9.CMS执行过程触发两次STW
- ![说明](./CMS执行示意图.png)

- 首先要搞清楚G1垃圾回收的过程
- 主要分为下面4个步骤：
- 初始标记（Initial Marking）           由于常规标记对象是否直接关联到GC roots，过程简单，停顿时间短
- 并发标记（Concurrent Marking） 由于可达性性分析，存在较长停顿
- 最终标记（Final Marking）           由于把并发标记时漏掉的那部分垃圾内存标记起来，比较少，停顿时间短
- 筛选回收（Live Data Couting and Evacuation）  对标记后的垃圾内存进行整理，按指定计划进行回收。

## 10.接口限流处理，分布式环境下
-
-

## 11.可作为GC root的对象
- a.java虚拟机栈(栈帧中的本地变量表)中的引用的对象。
- b.方法区中的类静态属性引用的对象。
- c.方法区中的常量引用的对象。
- d.本地方法栈中JNI本地方法的引用对象。
- [图示说明](https://yq.aliyun.com/articles/91017)

## 12.什么时候触发GC（MinorGC，MajorGC，FullGC）
- [不同回收类型](https://blog.csdn.net/E01014165/article/details/52249104)
- 回收为什么会停顿，JVM里面使用了一种叫可达性分析的技术来枚举根节点，可达性分析过程中，
是必须要求分析过程中树结构是不变的，也就是一致的。
这意味着这个过程中，当前JAVA进程必须暂停，这就是停顿的根本原因。

## 13.Java四种引用的作用
- [图示](https://www.cnblogs.com/dolphin0520/p/3784171.html)
- 软引用可以用来做缓存，缓存图片或数据，发生OOM时会回收该数据
- 弱引用会被回收，虚引用表示不存在

## 14.zookeeper为什么是奇数节点集群
- 会出现脑裂[图示](https://blog.csdn.net/u010476994/article/details/79806041)
- leader选举，要求 可用节点数量 > 总节点数量/2

## 15.如何保持分布式缓存的一致性，实现分布式Session
- 尽量使用分布式缓存，而不是本地缓存
- 写缓存如果无法保证完整性，尽量在需要时回源数据库，也不要把部分数据放入缓存
- 数据库与缓存保证弱一致性
- 读（先缓存，后数据库）写（先数据库，后缓存）
- [不同情况](http://blog.jobbole.com/113992/)