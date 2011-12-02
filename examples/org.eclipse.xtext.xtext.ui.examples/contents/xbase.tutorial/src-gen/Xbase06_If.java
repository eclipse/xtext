import org.eclipse.xtext.xbase.lib.IntegerExtensions;

@SuppressWarnings("all")
public class Xbase06_If {
  public static void main(final String[] args) {
    try {
    	int _length = "foo".length();
    	boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(_length, 3);
    	if (_operator_greaterThan) {/*"never true!"*/;
    	} else {/*"always true!"*/;
    	}
    	int _length_1 = "foo".length();
    	boolean _operator_greaterThan_1 = IntegerExtensions.operator_greaterThan(_length_1, 3);
    	if (_operator_greaterThan_1) {/*"never true!"*/;
    	}
    	boolean _xifexpression = false;
    	int _length_2 = "foo".length();
    	boolean _operator_greaterThan_2 = IntegerExtensions.operator_greaterThan(_length_2, 3);
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
