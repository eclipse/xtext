import org.eclipse.xtext.xbase.lib.ComparableExtensions;

@SuppressWarnings("all")
public class Xbase06_If {
  public static void main(final String[] args) {
    try {
    	int _length = "foo".length();
    	boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_length), ((Integer)3));
    	if (_operator_greaterThan) {/*"never true!"*/;
    	} else {/*"always true!"*/;
    	}
    	int _length_1 = "foo".length();
    	boolean _operator_greaterThan_1 = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_length_1), ((Integer)3));
    	if (_operator_greaterThan_1) {/*"never true!"*/;
    	}
    	boolean _xifexpression = false;
    	int _length_2 = "foo".length();
    	boolean _operator_greaterThan_2 = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_length_2), ((Integer)3));
    	if (_operator_greaterThan_2) {
    		_xifexpression = false;
    	} else {
    		_xifexpression = true;
    	}
    	if (_xifexpression) {/*"Xbase doesn\'t need the ternary operator"*/;
    	}
    } catch (Throwable t) {}
  }
}
