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

## 6.树结构解析
- [二叉平衡树，B+树](https://blog.csdn.net/u011240877/article/details/80490663)
- [B+树，B*树](https://blog.csdn.net/pengzhisen123/article/details/79927377)