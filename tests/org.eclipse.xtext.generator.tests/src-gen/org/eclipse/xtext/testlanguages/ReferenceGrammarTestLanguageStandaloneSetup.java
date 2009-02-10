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

public class ReferenceGrammarTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new ReferenceGrammarTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("referencegrammartestlanguage", resourceFactory);
		
	}
    

	/**
	 * initializes all EPackages generated for this language and registers them at EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		
			if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/reference/ReferenceGrammar")) {
				EPackage ReferenceGrammar = EcoreUtil2.loadEPackage(
						"classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.ecore",
						ReferenceGrammarTestLanguageStandaloneSetup.class.getClassLoader());
				if (ReferenceGrammar == null)
					throw new IllegalStateException(
							"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.ecore'");
				EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/reference/ReferenceGrammar", ReferenceGrammar);
			}
		
	}
	
}
