
@SuppressWarnings("all")
public class Xbase03_VariableDeclarations {
	public static void main(String[] args) {
		
		{
		  final String x = "A final value";
		  String y = "A non-final variable";
		  y = "can be modified";
		  final String s = "my String";
		  {
		    final String s_1 = "foo";
		  }
		}
	}
}
