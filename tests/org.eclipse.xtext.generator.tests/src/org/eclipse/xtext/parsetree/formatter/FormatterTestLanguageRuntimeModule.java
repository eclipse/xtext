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
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parsetree.formatter.AbstractFormatterTestLanguageRuntimeModule#getITokenSerializer()
	 */
	@Override
	protected Class<? extends ITokenSerializer> getITokenSerializer() {
		return FormattingTokenSerializerTestImpl.class;
	}
	
}
