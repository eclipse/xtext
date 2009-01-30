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
public class ContentAssistTestLanguageUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.testlanguages.ContentAssistTestLanguageStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.testlanguages.ContentAssistTestLanguageRuntimeModule(), new org.eclipse.xtext.testlanguages.ContentAssistTestLanguageUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.testlanguages.IContentAssistTestLanguage.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.testlanguages.IContentAssistTestLanguage.SCOPE;
	}
	
}
