import java.util.Comparator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class Xbase11_TypeCoercion {
  public int myMethod() throws Throwable {
    int _xblockexpression = (int) 0;
    {
      "string".length();
      final Integer i = Integer.valueOf("string".length());
      /* i; */
      Integer.valueOf("string".length()).toString();
      "string".toCharArray();
      /* "string".toCharArray()[3]; */
      final List<Character> l = (List<Character>)Conversions.doWrapArray("string".toCharArray());
      /* l; */
      final Comparator<String> _function = (String a, String b) -> {
        return Integer.valueOf(a.length()).compareTo(Integer.valueOf(b.length()));
      };
      final Comparator<String> comparator = _function;
      _xblockexpression = comparator.compare("1", " 2");
    }
    return _xblockexpression;
  }
}
