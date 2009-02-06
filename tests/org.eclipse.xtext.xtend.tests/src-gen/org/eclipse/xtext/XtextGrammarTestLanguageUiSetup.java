/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class XtextGrammarTestLanguageUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.XtextGrammarTestLanguageRuntimeModule(), new org.eclipse.xtext.XtextGrammarTestLanguageUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.IXtextGrammarTestLanguage.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.IXtextGrammarTestLanguage.SCOPE;
	}
	
}
