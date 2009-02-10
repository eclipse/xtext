/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ReferenceGrammarStandaloneSetup implements ISetup {

	public static void doSetup() {
		new ReferenceGrammarStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.reference.ReferenceGrammarRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtest", resourceFactory);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tst", resourceFactory);
		
	}
    

	/**
	 * initializes all EPackages generated for this language and registers them at EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		
			if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/reference/ReferenceGrammar")) {
				EPackage ReferenceGrammar = EcoreUtil2.loadEPackage(
						"classpath:/org/eclipse/xtext/reference/ReferenceGrammar.ecore",
						ReferenceGrammarStandaloneSetup.class.getClassLoader());
				if (ReferenceGrammar == null)
					throw new IllegalStateException(
							"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/reference/ReferenceGrammar.ecore'");
				EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/reference/ReferenceGrammar", ReferenceGrammar);
			}
		
	}
	
}
