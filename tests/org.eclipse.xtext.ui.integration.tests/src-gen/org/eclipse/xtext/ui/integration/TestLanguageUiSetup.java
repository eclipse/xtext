/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class TestLanguageUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.ui.integration.TestLanguageStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.ui.integration.TestLanguageRuntimeModule(), new org.eclipse.xtext.ui.integration.TestLanguageUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.ui.integration.ITestLanguage.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.ui.integration.ITestLanguage.SCOPE;
	}
	
}
