java JVM 练习笔记

1.HeapOOM目录

测试Java堆溢出场景

设置java虚拟机的启动参数：-verbose:gc -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError

将堆的最小值-Xms参数和最大值-Xmx参数 设置为一样即可避免自动扩展

 通过参数-XX:+HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析。
 
 运行结果：
 
 java.lang.OutOfMemoryError: Java heap space
 
Dumping heap to java_pid12344.hprof ...

Heap dump file created [27963980 bytes in 0.094 secs]

OOM异常很 常见，当出现java堆内存溢出时，异常堆栈信息“ java.lang.OutOfMemoryError” 后跟提示：“Java heap space”


2.JavaVMStackSOF目录

测试虚拟机栈和本地方法栈溢出

设置启动参数： -verbose:gc -Xss128k

在hotspot中，虚拟机栈和本地方法栈是同一个，没有分开

栈容量只由-Xss参数设定

如果线程请求的栈深度大于虚拟机所允许的最大深度，则抛出StackOverflowError异常。

运行结果：

stack length:1541

Exception in thread "main" java.lang.StackOverflowError

	at JavaVＭStackSOF.stackLeak(JavaVＭStackSOF.java:14)
	
 ........
