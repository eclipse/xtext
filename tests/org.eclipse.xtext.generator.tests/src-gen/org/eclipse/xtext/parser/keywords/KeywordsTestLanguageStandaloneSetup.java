/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class KeywordsTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new KeywordsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
			
			new org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup().doSetup();
			
		    registerEPackages();
		    
		    Injector injector = createInjector();
		    IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		    registerResourceFactory(resourceFactory);
		    return injector;
		    
	}
	
    
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("keywordstestlanguage", resourceFactory);
		
	}
    

	/**
	 * initializes all EPackages generated for this language and registers them at EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		
			if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2009/tmf/xtext/KeywordsTestLanguage")) {
				EPackage KeywordsTestLanguage = EcoreUtil2.loadEPackage(
						"classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.ecore",
						KeywordsTestLanguageStandaloneSetup.class.getClassLoader());
				if (KeywordsTestLanguage == null)
					throw new IllegalStateException(
							"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.ecore'");
				EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2009/tmf/xtext/KeywordsTestLanguage", KeywordsTestLanguage);
			}
		
	}
	
}
