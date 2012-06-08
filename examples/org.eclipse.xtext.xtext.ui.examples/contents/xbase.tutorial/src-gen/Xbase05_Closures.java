import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Xbase05_Closures {
  public static void main(final String[] args) {
    try {
        final String x = "Hello ";
        final Function1<String,String> _function = new Function1<String,String>() {
            public String apply(final String e) {
              String _plus = (x + e);
              return _plus;
            }
          };
        final Function1<String,String> f = _function;
        f.apply("World!");
        final ArrayList<String> list = CollectionLiterals.<String>newArrayList("a", "b", "c");
        final Function1<String,String> _function_1 = new Function1<String,String>() {
            public String apply(final String e) {
              String _upperCase = e.toUpperCase();
              return _upperCase;
            }
          };
        /*ListExtensions.<String, String>map(list, _function_1);*/
        final Function1<String,String> _function_2 = new Function1<String,String>() {
            public String apply(final String e) {
              String _upperCase = e.toUpperCase();
              return _upperCase;
            }
          };
        final Function1<? super String,? extends String> f2 = _function_2;
        f2.apply("simsalabim");
    } catch (Throwable t) {}
  }
}
