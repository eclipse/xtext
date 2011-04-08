import java.util.Comparator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@SuppressWarnings("all")
public class Xbase11_TypeCoercion {
	public static void main(String[] args) {
		
		{
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
		      public Integer apply(String a , String b) {
		        int _length_2 = a.length();
		        int _length_3 = b.length();
		        int _compareTo = ((Integer)_length_2).compareTo(((Integer)_length_3));
		        return _compareTo;
		      }
		    };
		  final Comparator<String> comparator = new Comparator<String>() {
		      public int compare(String arg0,String arg1) {
		        return _function.apply(arg0,arg1);
		      }
		  };
		}
	}
}
