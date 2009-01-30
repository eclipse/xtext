/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.parser.datatyperules.IDatatypeRulesTestLanguage;

public abstract class DatatypeRulesTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.parser.datatyperules.IDatatypeRulesTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("datatyperulestestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/DatatypeRulesTest")) {
					EPackage DatatypeRulesTestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.ecore",
							DatatypeRulesTestLanguageStandaloneSetup.class.getClassLoader());
					if (DatatypeRulesTestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/DatatypeRulesTest", DatatypeRulesTestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.parser.datatyperules.IDatatypeRulesTestLanguage.SCOPE;
	}
	
}
