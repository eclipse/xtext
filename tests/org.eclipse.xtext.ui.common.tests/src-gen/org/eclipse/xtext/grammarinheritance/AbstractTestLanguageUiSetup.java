/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class AbstractTestLanguageUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.grammarinheritance.AbstractTestLanguageStandaloneSetup.doSetup();
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.grammarinheritance.IAbstractTestLanguage.SCOPE;
	}
	
}
