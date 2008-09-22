/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;

public interface ILangA {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.crossrefs.LangA";
	public static final String NAME = "LangA";
	public static final String NAMESPACE = "org.eclipse.xtext.crossrefs";
	public static final String[] FILE_EXTENSIONS = new String[]{"langa"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID, org.eclipse.xtext.builtin.IXtextBuiltin.SCOPE);
	
}
