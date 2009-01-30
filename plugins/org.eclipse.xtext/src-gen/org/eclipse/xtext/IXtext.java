/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ILanguage;

public interface IXtext extends ILanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.Xtext";
	public static final String NAME = "Xtext";
	public static final String NAMESPACE = "org.eclipse.xtext";
	public static final String[] FILE_EXTENSIONS = new String[]{"xtext","xtext2"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID);
	
}
