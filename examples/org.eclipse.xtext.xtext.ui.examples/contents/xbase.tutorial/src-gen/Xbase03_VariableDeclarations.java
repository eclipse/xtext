import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xbase03_VariableDeclarations {
  public static void main(final String[] args) {
    try {
    	final String x = "A final value";
    	String y = "A non-final variable";
    	y = "can be modified";
    	final String s = "my String";
    	{
    		final String s1 = "foo";
    		StringExtensions.operator_plus(s, s1);
    	}
    } catch (Throwable t) {}
  }
}
