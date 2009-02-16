/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance;

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
public class InheritanceTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new InheritanceTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		
		org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguageStandaloneSetup.doSetup();
		registerEPackages();
		Injector injector = createInjector();
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		registerResourceFactory(resourceFactory);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.grammarinheritance.InheritanceTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("inheritancetestlanguage", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2009/tmf/xtext/InheritanceTestLanguage")) {
			EPackage inheritanceTest = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/grammarinheritance/inheritanceTest.ecore",
				InheritanceTestLanguageStandaloneSetup.class.getClassLoader());
			if (inheritanceTest == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/grammarinheritance/inheritanceTest.ecore'");
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2009/tmf/xtext/InheritanceTestLanguage", inheritanceTest);
		}
	}
	
}
