/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ILanguage;

public interface IFormatterTestLanguage extends ILanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage";
	public static final String NAME = "FormatterTestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.parsetree.formatter";
	public static final String[] FILE_EXTENSIONS = new String[]{"formattertestlanguage"};
	public static final IServiceScope SCOPE = ServiceScopeFactory.createScope(ID);
	
}
