/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.ui.integration.TestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtext_integration", resourceFactory);
		
	}
    

	/**
	 * initializes all EPackages generated for this language and registers them at EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		
			if (!EPackage.Registry.INSTANCE.containsKey("http://foo")) {
				EPackage foo = EcoreUtil2.loadEPackage(
						"classpath:/org/eclipse/xtext/ui/integration/foo.ecore",
						TestLanguageStandaloneSetup.class.getClassLoader());
				if (foo == null)
					throw new IllegalStateException(
							"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/ui/integration/foo.ecore'");
				EPackage.Registry.INSTANCE.put("http://foo", foo);
			}
		
	}
	
}
