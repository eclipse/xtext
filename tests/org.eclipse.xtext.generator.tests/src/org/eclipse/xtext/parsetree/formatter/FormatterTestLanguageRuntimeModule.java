/*
Generated with Xtext
 */
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatting.IFormatter;

/**
 * used to register components to be used within the IDE.
 */
public class FormatterTestLanguageRuntimeModule extends
		AbstractFormatterTestLanguageRuntimeModule {

	public Class<? extends IFormatter> bindIFormatter() {
		return FormattingTokenSerializerTestImpl.class;
	}

	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return FormatterTestValueConverters.class;
	}

}
