/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.conversion.IValueConverterService;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class DatatypeRulesTestLanguageRuntimeModule extends AbstractDatatypeRulesTestLanguageRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#getIValueConverterService()
	 */
	@Override
	protected Class<? extends IValueConverterService> getIValueConverterService() {
		return DatatypeRulesTestLanguageValueConverters.class;
	}
}
