/*
Generated with Xtext
*/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ILanguage;

public interface ILowerCaseNamedTestLanguage extends ILanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.generator.lowerCaseNamedTestLanguage";
	public static final String NAME = "LowerCaseNamedTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.generator";
	public static final String[] FILE_EXTENSIONS = new String[]{"lowercasenamedtestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID);
	
}
