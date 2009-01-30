/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ILanguage;

public interface IMultiValueFeatureTestLanguage extends ILanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.resource.metamodel.MultiValueFeatureTestLanguage";
	public static final String NAME = "MultiValueFeatureTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.resource.metamodel";
	public static final String[] FILE_EXTENSIONS = new String[]{"multivaluefeaturetestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID);
	
}
