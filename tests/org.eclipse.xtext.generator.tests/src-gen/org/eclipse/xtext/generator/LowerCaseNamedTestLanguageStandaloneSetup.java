/*
Generated with Xtext
*/
package org.eclipse.xtext.generator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.generator.ILowerCaseNamedTestLanguage;

public abstract class LowerCaseNamedTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.generator.LowerCaseNamedTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.generator.ILowerCaseNamedTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.generator.services.LowerCaseNamedTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("lowercasenamedtestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2009/tmf/xtext/lowerCaseNamedTestLanguage")) {
					EPackage lowerCaseNamedTestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.ecore",
							LowerCaseNamedTestLanguageStandaloneSetup.class.getClassLoader());
					if (lowerCaseNamedTestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2009/tmf/xtext/lowerCaseNamedTestLanguage", lowerCaseNamedTestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.generator.ILowerCaseNamedTestLanguage.SCOPE;
	}
	
}
