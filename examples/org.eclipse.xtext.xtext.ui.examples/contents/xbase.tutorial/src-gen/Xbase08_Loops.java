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
  public static void main(final String[] args) {
    try {
    	ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
    	final ArrayList<String> list = _newArrayList;
    	ArrayList<String> _arrayList = new ArrayList<String>();
    	final ArrayList<String> result = _arrayList;
    	List<String> _reverse = ListExtensions.<String>reverse(list);
    	for (final String x : _reverse) {
    		String _upperCase = x.toUpperCase();
    		CollectionExtensions.<String>operator_add(result, _upperCase);
    	}
    	int i = 0;
    	int _size = list.size();
    	boolean _operator_lessThan = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size));
    	boolean _while = _operator_lessThan;
    	while (_while) {
    		{
    			String _get = list.get(i);
    			String _operator_plus = StringExtensions.operator_plus("whiled-", _get);
    			CollectionExtensions.<String>operator_add(result, _operator_plus);
    			int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)i), ((Integer)1));
    			i = _operator_plus_1;
    		}
    		int _size_1 = list.size();
    		boolean _operator_lessThan_1 = ComparableExtensions.<Integer>operator_lessThan(((Integer)i), ((Integer)_size_1));
    		_while = _operator_lessThan_1;
    	}
    } catch (Throwable t) {}
  }
}
