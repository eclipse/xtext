package testdata;

public class ClassA implements InterfaceA, InterfaceB {

	public String getUpperCaseClassName() {
		return getClassName().toUpperCase();
	}

	public String getClassName() {
		return getClass().getSimpleName();
	}

}
