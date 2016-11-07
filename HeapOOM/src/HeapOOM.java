import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author liushahe2012
 *
 */
public class HeapOOM {
	static class OOMObject
	{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while(true)
		{
			list.add(new OOMObject());
		}
	}
}
