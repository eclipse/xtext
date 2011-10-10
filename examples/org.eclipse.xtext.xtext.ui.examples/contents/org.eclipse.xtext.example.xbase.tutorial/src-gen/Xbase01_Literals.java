import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class Xbase01_Literals {
  public static void main(final String[] args) {
    try {/*null*/;/*"Hello World"*/;/*42*/;/*true*/;/*false*/;/*java.lang.String.class*/;
    	CollectionLiterals.<Integer>newArrayList(((Integer)3), ((Integer)5), ((Integer)7));
    	CollectionLiterals.<String>newHashSet("foo", "bar", "baz");
    	Pair<Integer,String> _operator_mappedTo = ObjectExtensions.<Integer, String>operator_mappedTo(((Integer)1), "one");
    	Pair<Integer,String> _operator_mappedTo_1 = ObjectExtensions.<Integer, String>operator_mappedTo(((Integer)2), "two");
    	Pair<Integer,String> _operator_mappedTo_2 = ObjectExtensions.<Integer, String>operator_mappedTo(((Integer)3), "three");
    	CollectionLiterals.<Integer, String>newHashMap(_operator_mappedTo, _operator_mappedTo_1, _operator_mappedTo_2);
    } catch (Throwable t) {}
  }
}
