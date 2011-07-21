package testdata;

public class ClassB implements InterfaceA, InterfaceB {

	public String getUpperCaseClassName() {
		return getClassName().toUpperCase();
	}

	public String getClassName() {
		return getClass().getSimpleName();
	}

}
