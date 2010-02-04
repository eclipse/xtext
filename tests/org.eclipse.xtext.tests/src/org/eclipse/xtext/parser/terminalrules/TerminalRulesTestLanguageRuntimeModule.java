/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * used to register components to be used within the IDE.
 */
public class TerminalRulesTestLanguageRuntimeModule extends AbstractTerminalRulesTestLanguageRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return TerminalRuleTestLanguageConverters.class;
	}
}
