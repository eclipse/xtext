package org.eclipse.xtext.builtin.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractAnnotationBasedValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;

public class BuiltInConverters extends AbstractAnnotationBasedValueConverterService {
	
	@ValueConverter(rule="ID")
	public IValueConverter ID() {
		return new AbstractToStringConverter() {
			@Override
			protected Object internalToValue(String string) {
				return string.startsWith("^")?string.substring(1):string;
			}
		};
	}
	
	@ValueConverter(rule="STRING")
	public IValueConverter STRING() {
		return new AbstractToStringConverter() {
			public Object internalToValue(String val) {
				return val.substring(1, val.length()-1);
			}
		};
	}
	
	@ValueConverter(rule="INT")
	public IValueConverter INT() {
		return new AbstractToStringConverter() {
			public Object internalToValue(String val) {
				return Integer.valueOf(val);
			}
		};
	}
	
	
	
}
