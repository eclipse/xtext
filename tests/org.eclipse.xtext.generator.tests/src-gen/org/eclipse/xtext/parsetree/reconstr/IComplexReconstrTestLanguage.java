/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;

public interface IComplexReconstrTestLanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestLanguage";
	public static final String NAME = "ComplexReconstrTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.parsetree.reconstr";
	public static final String[] FILE_EXTENSIONS = new String[]{"complexreconstrtestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID, org.eclipse.xtext.builtin.IXtextBuiltin.SCOPE);
	
}
