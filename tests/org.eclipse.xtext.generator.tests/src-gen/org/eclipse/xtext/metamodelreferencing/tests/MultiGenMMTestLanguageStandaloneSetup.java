/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests;

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
public class MultiGenMMTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new MultiGenMMTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("multigenmmtestlanguage", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/tests/SimpleTest")) {
			EPackage SimpleTest = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore",
				MultiGenMMTestLanguageStandaloneSetup.class.getClassLoader());
			if (SimpleTest == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore'");
			EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/tests/SimpleTest", SimpleTest);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/tests/OtherTest")) {
			EPackage OtherTest = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/metamodelreferencing/tests/OtherTest.ecore",
				MultiGenMMTestLanguageStandaloneSetup.class.getClassLoader());
			if (OtherTest == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/metamodelreferencing/tests/OtherTest.ecore'");
			EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/tests/OtherTest", OtherTest);
		}
	}
	
}
