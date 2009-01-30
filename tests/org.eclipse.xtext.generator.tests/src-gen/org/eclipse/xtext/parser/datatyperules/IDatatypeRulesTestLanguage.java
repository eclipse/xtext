/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ILanguage;

public interface IDatatypeRulesTestLanguage extends ILanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage";
	public static final String NAME = "DatatypeRulesTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.parser.datatyperules";
	public static final String[] FILE_EXTENSIONS = new String[]{"datatyperulestestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID);
	
}
