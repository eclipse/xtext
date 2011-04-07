import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xbase08_Loops {
	public static void main(String[] args) {
		
		{
		  ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
		  final ArrayList<String> list = _newArrayList;
		  ArrayList<String> _arrayList = new ArrayList<String>();
		  final ArrayList<String> result = _arrayList;
		  final ArrayList<String> typeConverted_list = (ArrayList<String>)list;
		  List<String> _reverse = ListExtensions.<String>reverse(typeConverted_list);
		  for (String x : _reverse) {
		    final ArrayList<String> typeConverted_result = (ArrayList<String>)result;
		    String _upperCase = x.toUpperCase();
		    CollectionExtensions.<String>operator_add(typeConverted_result, _upperCase);
		  }
		  Integer i = 0;
		  final Integer typeConverted_i = (Integer)i;
		  int _size = list.size();
		  boolean _operator_lessThan = ComparableExtensions.<Integer>operator_lessThan(typeConverted_i, _size);
		  Boolean _xwhileexpression = _operator_lessThan;
		  while (_xwhileexpression) {
		    {
		      final ArrayList<String> typeConverted_result_1 = (ArrayList<String>)result;
		      final Integer typeConverted_i_1 = (Integer)i;
		      String _get = list.get(typeConverted_i_1);
		      String _operator_plus = StringExtensions.operator_plus("whiled-", _get);
		      CollectionExtensions.<String>operator_add(typeConverted_result_1, _operator_plus);
		      int _operator_plus_1 = IntegerExtensions.operator_plus(i, 1);
		      i = ((Integer)_operator_plus_1);
		    }
		    final Integer typeConverted_i_2 = (Integer)i;
		    int _size_1 = list.size();
		    boolean _operator_lessThan_1 = ComparableExtensions.<Integer>operator_lessThan(typeConverted_i_2, _size_1);
		    _xwhileexpression = _operator_lessThan_1;
		  }
		}
	}
}
