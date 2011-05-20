
@SuppressWarnings("all")
public class Xbase09_Exceptions {
	public static void main(String[] args) {
		
		{
		  try {
		    ((Object) null).toString();
		  } catch (NullPointerException e) { 
		    RuntimeException _runtimeException = new RuntimeException(e);
		    throw _runtimeException;
		  } finally {
		  }/*null*/;
		}
	}
}
