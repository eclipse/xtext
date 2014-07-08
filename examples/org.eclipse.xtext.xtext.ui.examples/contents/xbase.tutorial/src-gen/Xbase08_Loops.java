import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Xbase08_Loops {
  public ArrayList<String> myMethod() throws Throwable {
    ArrayList<String> _xblockexpression = null;
    {
      final ArrayList<String> list = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
      final ArrayList<String> result = new ArrayList<String>();
      List<String> _reverse = ListExtensions.<String>reverse(list);
      for (final String x : _reverse) {
        String _upperCase = x.toUpperCase();
        result.add(_upperCase);
      }
      /* result; */
      int i = 0;
      while ((i < list.size())) {
        {
          String _get = list.get(i);
          String _plus = ("whiled-" + _get);
          result.add(_plus);
          i = (i + 1);
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
