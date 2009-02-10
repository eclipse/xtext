/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules;

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
public class DatatypeRulesTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new DatatypeRulesTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguageRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("datatyperulestestlanguage", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/DatatypeRulesTest")) {
			EPackage DatatypeRulesTestLanguage = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.ecore",
				DatatypeRulesTestLanguageStandaloneSetup.class.getClassLoader());
			if (DatatypeRulesTestLanguage == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.ecore'");
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/DatatypeRulesTest", DatatypeRulesTestLanguage);
		}
	}
	
}
