/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.parser.keywords.IKeywordsTestLanguage;

public abstract class KeywordsTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.parser.keywords.IKeywordsTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("keywordstestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2009/tmf/xtext/KeywordsTestLanguage")) {
					EPackage KeywordsTestLanguage = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.ecore",
							KeywordsTestLanguageStandaloneSetup.class.getClassLoader());
					if (KeywordsTestLanguage == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.ecore'");
					EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2009/tmf/xtext/KeywordsTestLanguage", KeywordsTestLanguage);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.parser.keywords.IKeywordsTestLanguage.SCOPE;
	}
	
}
