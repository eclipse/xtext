/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;

public interface ITerminalRulesTestLanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage";
	public static final String NAME = "TerminalRulesTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.parser.terminalrules";
	public static final String[] FILE_EXTENSIONS = new String[]{"terminalrulestestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID, null);
	
}
