
/**
 * -verbose:gc -Xss128k
 * @author liu
 *
 */
public class JavaV£ÍStackSOF {

	private int stackLength = 1;
	
	public void stackLeak()
	{
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaV£ÍStackSOF oom = new JavaV£ÍStackSOF();
		
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
