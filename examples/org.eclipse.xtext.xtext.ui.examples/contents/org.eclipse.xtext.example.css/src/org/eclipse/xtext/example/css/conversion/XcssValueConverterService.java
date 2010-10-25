package org.eclipse.xtext.example.css.conversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

public class XcssValueConverterService extends DefaultTerminalConverters {

	@ValueConverter(rule = "HEXINT")
	public IValueConverter<Integer> INT() {
		return new IValueConverter<Integer>() {

			public Integer toValue(String string, AbstractNode node)
					throws ValueConverterException {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to int.", node, null);
				try {
					return Integer.valueOf(string, 16);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to int.", node, e);
				}
			}

			public String toString(Integer value)
					throws ValueConverterException {
				return Integer.toHexString(value.intValue());
			}
			
		};
	}
	
}
