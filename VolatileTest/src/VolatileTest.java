
/**
 * volatile �������ԣ�
 * 1.��֤�����������̵߳Ŀɼ��ԣ�����һ���߳��޸������������ֵ����ֵ���������߳���˵�������ɼ��ġ�
 * 2.��ָֹ���������Ż���
 * 
 * volatile�����ױ����ã� volatile �������������̰߳�ȫ����������Ϊ����ԭ�Ӳ�����
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
		
		//�ȴ������ۼ��̶߳�����
		while(Thread.activeCount() > 1)
		{
			Thread.yield();
		}
		
		System.out.println(race);
		//������������20*10000
		//��Ϊ����volatile���εı�����jvm�����ֻ�Ǳ�֤�����ڴ���ص��̹߳����ڴ��ֵ�����µ�
		//��������߳�1���߳�2 �ڽ���read,load �����У��������ڴ���race��ֵ����5����ô�������������µ�ֵ
		//���߳�1��race�����޸�֮�󣬻�write�����ڴ��У����ڴ��е�race�����ͻ��Ϊ6
		//�߳�2�����Ѿ�����read,load�������ڽ�������֮��Ҳ��������ڴ�race�ı���ֵΪ6
		//���������̼߳�ʱ��volatile�ؼ����޸�֮�󣬻��ǻ���ڲ����������
	}
	
}
