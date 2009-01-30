/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class ReferenceGrammarUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.reference.ReferenceGrammarStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.reference.ReferenceGrammarRuntimeModule(), new org.eclipse.xtext.reference.ReferenceGrammarUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.reference.IReferenceGrammar.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.reference.IReferenceGrammar.SCOPE;
	}
	
}
