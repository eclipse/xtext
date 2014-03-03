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
      int _length = "string".length();
      Integer.valueOf(_length).toString();
      "string".toCharArray();
      char[] _charArray = "string".toCharArray();
      /* _charArray[3]; */
      final List<Character> l = ((List<Character>)Conversions.doWrapArray("string".toCharArray()));
      /* l; */
      final Comparator<String> _function = new Comparator<String>() {
        public int compare(final String a, final String b) {
          int _length = a.length();
          int _length_1 = b.length();
          return Integer.valueOf(_length).compareTo(Integer.valueOf(_length_1));
        }
      };
      final Comparator<String> comparator = _function;
      _xblockexpression = (comparator.compare("1", " 2"));
    }
    return _xblockexpression;
  }
}
