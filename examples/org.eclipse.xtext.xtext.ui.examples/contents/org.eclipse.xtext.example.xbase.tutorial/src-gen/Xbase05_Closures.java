import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xbase05_Closures {
	public static void main(String[] args) {
		
		{
		  final String x = "Hello ";
		  final Function1<String,String> function = new Function1<String,String>() {
		      public String apply(String e) {
		        final String typeConverted_e = (String)e;
		        String _operator_plus = StringExtensions.operator_plus(x, typeConverted_e);
		        return _operator_plus;
		      }
		    };
		  final Function1<String,String> f = function;
		  f.apply("World!");
		  ArrayList<String> _newArrayList = CollectionLiterals.newArrayList("a", "b", "c");
		  final ArrayList<String> list = _newArrayList;
		  final ArrayList<String> typeConverted_list = (ArrayList<String>)list;
		  final Function1<String,String> function_1 = new Function1<String,String>() {
		      public String apply(String e_1) {
		        String _upperCase = e_1.toUpperCase();
		        return _upperCase;
		      }
		    };
		  ListExtensions.map(typeConverted_list, function_1);
		  final Function1<String,String> function_2 = new Function1<String,String>() {
		      public String apply(String e_2) {
		        String _upperCase_1 = e_2.toUpperCase();
		        return _upperCase_1;
		      }
		    };
		  final Function1<String,String> f2 = function_2;
		  final Function1<String,String> typeConverted_f2 = (Function1<String,String>)f2;
		  typeConverted_f2.apply("simsalabim");
		}
	}
}
