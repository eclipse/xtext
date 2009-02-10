/*
Generated with Xtext
*/
package org.eclipse.xtext.generator;

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
public class LowerCaseNamedTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new LowerCaseNamedTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.generator.LowerCaseNamedTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("lowercasenamedtestlanguage", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2009/tmf/xtext/lowerCaseNamedTestLanguage")) {
			EPackage lowerCaseNamedTestLanguage = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.ecore",
				LowerCaseNamedTestLanguageStandaloneSetup.class.getClassLoader());
			if (lowerCaseNamedTestLanguage == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.ecore'");
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2009/tmf/xtext/lowerCaseNamedTestLanguage", lowerCaseNamedTestLanguage);
		}
	}
	
}
