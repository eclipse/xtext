import java.util.Comparator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@SuppressWarnings("all")
public class Xbase11_TypeCoercion {
  public static void main(final String[] args) {
    try {
    	"string".length();
    	int _length = "string".length();
    	final Integer i = ((Integer)_length);
    	int _length_1 = "string".length();
    	((Integer)_length_1).toString();
    	"string".toCharArray();
    	char[] _charArray = "string".toCharArray();
    	final List<Character> l = ((List<Character>)Conversions.doWrapArray(_charArray));
    	char[] _charArray_1 = "string".toCharArray();
    	((List<Character>)Conversions.doWrapArray(_charArray_1)).get(3);
    	final Function2<String,String,Integer> _function = new Function2<String,String,Integer>() {
    			public Integer apply(final String a , final String b) {
    				int _length = a.length();
    				int _length_1 = b.length();
    				int _compareTo = ((Integer)_length).compareTo(((Integer)_length_1));
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
