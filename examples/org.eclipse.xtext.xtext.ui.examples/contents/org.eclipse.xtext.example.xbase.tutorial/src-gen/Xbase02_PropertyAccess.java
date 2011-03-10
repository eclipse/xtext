import helper.PropertyAccess;

@SuppressWarnings("all")
public class Xbase02_PropertyAccess {
	public static void main(String[] args) {
		
		{
		  final PropertyAccess bean = new PropertyAccess();
		  bean.setMyProperty("Hello World!");
		  bean.getMyProperty();
		}
	}
}
