
/**
 * volatile 两种特性：
 * 1.保证变量对所有线程的可见性，即当一个线程修改了这个变量的值，新值对于其他线程来说是立即可见的。
 * 2.禁止指令重排序优化。
 * 
 * volatile很容易被误用， volatile 变量不能用作线程安全计数器，因为不是原子操作。
 * 
 * @author liushahe2012
 *
 */
public class VolatileTest {

	public static volatile int race = 0;
	
	public static void increase()
	{
		race ++;
	}
	private static final int count = 20;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[count];
		for(int i = 0; i < count; i++)
		{
			threads[i] = new Thread(new Runnable(){
				public void run()
				{
					for(int j = 0; j < 10000; j++)
					{
						increase();
					}
				}
			});
			threads[i].start();
		}
		
		//等待所有累加线程都结束
		while(Thread.activeCount() > 1)
		{
			Thread.yield();
		}
		
		System.out.println(race);
		//输出结果并不是20*10000
		//因为对于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
		//例如假如线程1，线程2 在进行read,load 操作中，发现主内存中race的值都是5，那么都会加载这个最新的值
		//在线程1堆race进行修改之后，会write到主内存中，主内存中的race变量就会变为6
		//线程2由于已经进行read,load操作，在进行运算之后，也会更新主内存race的变量值为6
		//导致两个线程及时用volatile关键字修改之后，还是会存在并发的情况。
	}
	
}
