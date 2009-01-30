/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.crossrefs.ILangATestLanguage;

public abstract class LangATestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.crossrefs.LangATestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.crossrefs.ILangATestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.crossrefs.services.LangATestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("langatestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/langATestLanguage")) {
					EPackage langATestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/crossrefs/langATestLanguage.ecore",
							LangATestLanguageStandaloneSetup.class.getClassLoader());
					if (langATestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/crossrefs/langATestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/langATestLanguage", langATestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.crossrefs.ILangATestLanguage.SCOPE;
	}
	
}
