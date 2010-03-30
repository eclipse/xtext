package org.eclipse.xtext.example.arithmetics;

import java.math.BigDecimal;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

public class MyValueConverterService extends DefaultTerminalConverters {

	@ValueConverter(rule = "NUMBER")
	public IValueConverter<BigDecimal> NUMBER() {
		return new AbstractNullSafeConverter<BigDecimal>() {
			
			@Override
			protected BigDecimal internalToValue(String string, AbstractNode node) {
				return new BigDecimal(string);
			}

			@Override
			protected String internalToString(BigDecimal value) {
				return value.toString();
			}
		};
	}
}
