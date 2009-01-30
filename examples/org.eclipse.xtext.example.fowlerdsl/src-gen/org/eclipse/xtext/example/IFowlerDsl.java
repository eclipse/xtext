/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ILanguage;

public interface IFowlerDsl extends ILanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.example.FowlerDsl";
	public static final String NAME = "FowlerDsl";
	public static final String NAMESPACE = "org.eclipse.xtext.example";
	public static final String[] FILE_EXTENSIONS = new String[]{"fowlerdsl"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID);
	
}
