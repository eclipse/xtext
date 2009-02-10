/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class FowlerDslStandaloneSetup implements ISetup {

	public static void doSetup() {
		new FowlerDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		
		org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
		registerEPackages();
		Injector injector = createInjector();
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		registerResourceFactory(resourceFactory);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.example.FowlerDslRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("fowlerdsl", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://example.xtext.org/FowlerDsl")) {
			EPackage fowlerdsl = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/example/fowlerdsl.ecore",
				FowlerDslStandaloneSetup.class.getClassLoader());
			if (fowlerdsl == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/example/fowlerdsl.ecore'");
			EPackage.Registry.INSTANCE.put("http://example.xtext.org/FowlerDsl", fowlerdsl);
		}
	}
	
}
