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
		  ArrayList<String> _newArrayList = CollectionLiterals.newArrayList("foo", "bar", "baz");
		  final ArrayList<String> list = _newArrayList;
		  final ArrayList<String> result = new ArrayList<String>();
		  final ArrayList<String> typeConverted_list = (ArrayList<String>)list;
		  List<String> _reverse = ListExtensions.reverse(typeConverted_list);
		  for (String x : _reverse) {
		    String _upperCase = x.toUpperCase();
		    CollectionExtensions.operator_add(result, _upperCase);
		  }
		  Integer i = 0;
		  int _size = list.size();
		  boolean _operator_lessThan = ComparableExtensions.operator_lessThan(i, _size);
		  Boolean _xwhileexpression = ((Boolean)_operator_lessThan);
		  while (_xwhileexpression) {
		    {
		      final Integer typeConverted_i = (Integer)i;
		      String _get = list.get(typeConverted_i);
		      String _operator_plus = StringExtensions.operator_plus("whiled-", _get);
		      CollectionExtensions.operator_add(result, _operator_plus);
		      int _operator_plus_1 = IntegerExtensions.operator_plus(i, 1);
		      i = ((Integer)_operator_plus_1);
		    }
		    int _size_1 = list.size();
		    boolean _operator_lessThan_1 = ComparableExtensions.operator_lessThan(i, _size_1);
		    _xwhileexpression = ((Boolean)_operator_lessThan_1);
		  }
		}
	}
}
