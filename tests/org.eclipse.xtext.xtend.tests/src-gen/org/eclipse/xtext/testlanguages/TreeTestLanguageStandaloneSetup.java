/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TreeTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new TreeTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.testlanguages.TreeTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("treetestlanguage", resourceFactory);
		
	}
    

	/**
	 * initializes all EPackages generated for this language and registers them at EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		
			if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/TreeTestLanguage")) {
				EPackage TreeTestLanguage = EcoreUtil2.loadEPackage(
						"classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.ecore",
						TreeTestLanguageStandaloneSetup.class.getClassLoader());
				if (TreeTestLanguage == null)
					throw new IllegalStateException(
							"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.ecore'");
				EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/TreeTestLanguage", TreeTestLanguage);
			}
		
	}
	
}
