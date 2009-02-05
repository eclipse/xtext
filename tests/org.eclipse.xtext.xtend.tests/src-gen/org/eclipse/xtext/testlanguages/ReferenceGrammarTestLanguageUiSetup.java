/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class ReferenceGrammarTestLanguageUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageRuntimeModule(), new org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.testlanguages.IReferenceGrammarTestLanguage.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.testlanguages.IReferenceGrammarTestLanguage.SCOPE;
	}
	
}
