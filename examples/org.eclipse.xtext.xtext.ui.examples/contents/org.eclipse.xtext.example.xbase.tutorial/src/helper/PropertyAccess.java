package helper;

public class PropertyAccess {
	
	private String myProperty;
	private final String myReadOnlyProperty = "readOnly";
	public String publicField;
	
	public void setMyProperty(String myProperty) {
		this.myProperty = myProperty;
	}
	
	public String getMyProperty() {
		return myProperty;
	}
	
	public String getMyReadOnlyProperty() {
		return myReadOnlyProperty;
	}
	
}
