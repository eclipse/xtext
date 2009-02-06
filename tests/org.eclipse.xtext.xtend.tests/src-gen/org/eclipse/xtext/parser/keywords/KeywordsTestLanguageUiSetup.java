/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class KeywordsTestLanguageUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.parser.keywords.KeywordsTestLanguageStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule(), new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.parser.keywords.IKeywordsTestLanguage.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.parser.keywords.IKeywordsTestLanguage.SCOPE;
	}
	
}
