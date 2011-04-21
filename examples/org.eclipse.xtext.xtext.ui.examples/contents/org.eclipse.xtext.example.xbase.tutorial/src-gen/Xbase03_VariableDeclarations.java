import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xbase03_VariableDeclarations {
	public static void main(String[] args) {
		
		{
		  final String x = "A final value";
		  String y = "A non-final variable";
		  y = "can be modified";
		  final String s = "my String";
		  {
		    final String s1 = "foo";
		    final String typeConverted_s1 = (String)s1;
		    StringExtensions.operator_plus(s, typeConverted_s1);
		  }
		}
	}
}
