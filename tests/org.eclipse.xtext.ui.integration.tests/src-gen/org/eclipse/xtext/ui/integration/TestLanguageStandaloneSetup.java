/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.ui.integration.ITestLanguage;

public abstract class TestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.ui.integration.TestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.ui.integration.ITestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.ui.integration.services.TestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtext_integration", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://foo")) {
					EPackage foo = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/ui/integration/foo.ecore",
							TestLanguageStandaloneSetup.class.getClassLoader());
					if (foo == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/ui/integration/foo.ecore'");
					EPackage.Registry.INSTANCE.put("http://foo", foo);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.ui.integration.ITestLanguage.SCOPE;
	}
	
}
