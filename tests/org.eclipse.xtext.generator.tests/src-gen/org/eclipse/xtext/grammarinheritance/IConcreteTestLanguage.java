/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;

public interface IConcreteTestLanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage";
	public static final String NAME = "ConcreteTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.grammarinheritance";
	public static final String[] FILE_EXTENSIONS = new String[]{"concretetestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID, org.eclipse.xtext.grammarinheritance.IAbstractTestLanguage.SCOPE);
	
}
