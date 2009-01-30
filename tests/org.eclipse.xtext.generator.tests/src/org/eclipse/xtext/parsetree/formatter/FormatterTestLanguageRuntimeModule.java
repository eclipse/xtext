/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class FormatterTestLanguageRuntimeModule extends AbstractFormatterTestLanguageRuntimeModule {

	@Override
	public Class<? extends ITokenSerializer> bindITokenSerializer() {
		return FormattingTokenSerializerTestImpl.class;
	}
	
}
