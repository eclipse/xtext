/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;

public interface IHiddenTerminalsTestLanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage";
	public static final String NAME = "HiddenTerminalsTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.parser.terminalrules";
	public static final String[] FILE_EXTENSIONS = new String[]{"hiddenterminalstestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID, null);
	
}
