/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * used to register components to be used at runtime.
 */
public class Bug250313RuntimeModule extends AbstractBug250313RuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return Converters.class;
	}

	public static class Converters extends DefaultTerminalConverters {

		@ValueConverter(rule = "Datatype")
		public IValueConverter<String> Datatype() {
			return new AbstractNullSafeConverter<String>() {
				@Override
				protected String internalToValue(String string, AbstractNode node) {
					return "str";
				}

				@Override
				protected String internalToString(String value) {
					throw new UnsupportedOperationException();
				}
			};
		}

		@ValueConverter(rule = "NestedDatatype")
		public IValueConverter<String> NestedDatatype() {
			return new AbstractNullSafeConverter<String>() {
				@Override
				protected String internalToValue(String string, AbstractNode node) {
					return "str";
				}

				@Override
				protected String internalToString(String value) {
					throw new UnsupportedOperationException();
				}
			};
		}

	}

}
