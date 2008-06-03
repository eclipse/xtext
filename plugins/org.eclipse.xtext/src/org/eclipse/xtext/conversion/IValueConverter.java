package org.eclipse.xtext.conversion;

public interface IValueConverter {
	IValueConverter NO_OP_CONVERTER = new IValueConverter() {
		public String toString(Object value) {
			return (String) value;
		}
		public Object toValue(String string) {
			return string;
		}
	};
	public Object toValue(String string);
	public String toString(Object value);
}
