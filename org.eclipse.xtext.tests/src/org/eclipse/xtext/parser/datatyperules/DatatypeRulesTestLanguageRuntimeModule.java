/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * used to register components to be used within the IDE.
 */
public class DatatypeRulesTestLanguageRuntimeModule extends AbstractDatatypeRulesTestLanguageRuntimeModule {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.service.DefaultRuntimeModule#getIValueConverterService()
	 */
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return DatatypeRulesTestLanguageValueConverters.class;
	}
}
