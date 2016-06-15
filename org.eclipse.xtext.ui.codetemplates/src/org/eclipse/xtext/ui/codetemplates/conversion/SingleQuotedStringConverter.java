package org.eclipse.xtext.ui.codetemplates.conversion;

import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.util.Strings;

public class SingleQuotedStringConverter extends STRINGValueConverter {

	@Override
	protected String toEscapedString(String value) {
		return '\'' + Strings.convertToJavaString(value, false) + '\'';
	}
	
}
