import java.util.Comparator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@SuppressWarnings("all")
public class Xbase11_TypeCoercion {
  public static void main(final String[] args) {
    try {
        "string".length();
        final Integer i = Integer.valueOf("string".length());
        /*i;*/
        int _length = "string".length();
        Integer.valueOf(_length).toString();
        "string".toCharArray();
        final List<Character> l = ((List<Character>)Conversions.doWrapArray("string".toCharArray()));
        char[] _charArray = "string".toCharArray();
        ((List<Character>)Conversions.doWrapArray(_charArray)).get(3);
        final Function2<String,String,Integer> _function = new Function2<String,String,Integer>() {
            public Integer apply(final String a, final String b) {
              int _length = a.length();
              int _length_1 = b.length();
              int _compareTo = Integer.valueOf(_length).compareTo(Integer.valueOf(_length_1));
              return _compareTo;
            }
          };
        final Comparator<String> comparator = new Comparator<String>() {
            public int compare(String o1,String o2) {
              return _function.apply(o1,o2);
            }
        };
    } catch (Throwable t) {}
  }
}
