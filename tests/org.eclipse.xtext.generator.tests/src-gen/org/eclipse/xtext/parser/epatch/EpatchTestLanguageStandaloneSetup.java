/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.parser.epatch.IEpatchTestLanguage;

public abstract class EpatchTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.parser.epatch.EpatchTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.parser.epatch.IEpatchTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("epatchtestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/EpatchTestLanguage")) {
					EPackage EpatchTestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.ecore",
							EpatchTestLanguageStandaloneSetup.class.getClassLoader());
					if (EpatchTestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/EpatchTestLanguage", EpatchTestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.parser.epatch.IEpatchTestLanguage.SCOPE;
	}
	
}
