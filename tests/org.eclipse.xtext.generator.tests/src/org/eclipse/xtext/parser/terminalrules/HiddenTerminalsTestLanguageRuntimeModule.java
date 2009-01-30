/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.conversion.IValueConverterService;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class HiddenTerminalsTestLanguageRuntimeModule extends AbstractHiddenTerminalsTestLanguageRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	@Override
	protected Class<? extends IValueConverterService> getIValueConverterService() {
		return TerminalRuleTestLanguageConverters.class;
	}
	
}
