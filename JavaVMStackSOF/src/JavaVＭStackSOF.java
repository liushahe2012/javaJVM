
/**
 * -verbose:gc -Xss128k
 * @author liu
 *
 */
public class JavaV��StackSOF {

	private int stackLength = 1;
	
	public void stackLeak()
	{
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaV��StackSOF oom = new JavaV��StackSOF();
		
		try{
			oom.stackLeak();
		}
		catch(Throwable e)
		{
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}
