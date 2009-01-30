/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.conversion.IValueConverterService;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class TerminalRulesTestLanguageRuntimeModule extends AbstractTerminalRulesTestLanguageRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}
	
	protected Class<? extends IValueConverterService> getIValueConverterService() {
		return TerminalRuleTestLanguageConverters.class;
	}
}
