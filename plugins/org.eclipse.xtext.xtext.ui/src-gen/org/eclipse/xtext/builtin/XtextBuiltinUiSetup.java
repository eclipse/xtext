/*
Generated with Xtext
*/
package org.eclipse.xtext.builtin;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class XtextBuiltinUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.builtin.IXtextBuiltin.SCOPE;
	}
	
}
