package testdata;

import java.util.Comparator;

/**
 * @since 2.4
 */
public class CoercionClient {
	public Comparator<String> comparatorField;
	private Object[] array;

	public void setComparator(Comparator<String> comp) {
		this.comparatorField = comp;
	}
	
	public int compare(String s1, String s2) {
		return comparatorField.compare(s1, s2);
	}
	
	public void setArray(Object[] array) {
		this.array = array;
	}
	
	public void setVarArgArray(String... array) {
		this.array = array;
	}
	
	public Object[] getArray() {
		return array;
	}
}
