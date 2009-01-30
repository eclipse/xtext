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

import org.eclipse.xtext.testlanguages.IOptionalEmptyTestLanguage;

public abstract class OptionalEmptyTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.testlanguages.IOptionalEmptyTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("optionalemptytestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/OptionalEmpty")) {
					EPackage OptionalEmpty = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/testlanguages/OptionalEmpty.ecore",
							OptionalEmptyTestLanguageStandaloneSetup.class.getClassLoader());
					if (OptionalEmpty == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/OptionalEmpty.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/OptionalEmpty", OptionalEmpty);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.testlanguages.IOptionalEmptyTestLanguage.SCOPE;
	}
	
}
