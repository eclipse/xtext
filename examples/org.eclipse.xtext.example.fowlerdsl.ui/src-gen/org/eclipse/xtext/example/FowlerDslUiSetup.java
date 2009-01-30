/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class FowlerDslUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.example.FowlerDslStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.example.FowlerDslRuntimeModule(), new org.eclipse.xtext.example.FowlerDslUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.example.IFowlerDsl.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.example.IFowlerDsl.SCOPE;
	}
	
}
