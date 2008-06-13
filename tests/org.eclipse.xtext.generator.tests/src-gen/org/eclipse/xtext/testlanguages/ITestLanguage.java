/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;

public interface ITestLanguage {

	/**
	 * the unique identifier of this language. 
	 * To be used to get the language descriptor and related services from the registry.
	 * Within ILanguageServices it is encouraged to use dependency injection instead
	 * of directly accessing the ServiceRegistry 
	 */
	public static final String ID = "org.eclipse.xtext.testlanguages.TestLanguage";
	public static final String NAME = "TestLanguage";
	public static final String NAMESPACE = "org.eclipse.xtext.testlanguages";
	
}
