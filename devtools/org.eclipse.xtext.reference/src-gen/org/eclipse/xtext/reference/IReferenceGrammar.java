/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;

public interface IReferenceGrammar {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.reference.ReferenceGrammar";
	public static final String NAME = "ReferenceGrammar";
	public static final String NAMESPACE = "org.eclipse.xtext.reference";
	public static final String[] FILE_EXTENSIONS = new String[]{"xtest","tst"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID, org.eclipse.xtext.builtin.IXtextBuiltin.SCOPE);
	
}
