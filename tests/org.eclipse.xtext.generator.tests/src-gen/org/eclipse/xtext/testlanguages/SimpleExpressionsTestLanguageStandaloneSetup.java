/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.testlanguages.ISimpleExpressionsTestLanguage;

public abstract class SimpleExpressionsTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.testlanguages.ISimpleExpressionsTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simpleexpressionstestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/xtext/test/simpleExpressions")) {
					EPackage simpleExpressions = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/testlanguages/simpleExpressions.ecore",
							SimpleExpressionsTestLanguageStandaloneSetup.class.getClassLoader());
					if (simpleExpressions == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/simpleExpressions.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/test/simpleExpressions", simpleExpressions);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.testlanguages.ISimpleExpressionsTestLanguage.SCOPE;
	}
	
}
