package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class Bug297105TestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new Bug297105TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.parser.terminalrules.Bug297105TestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/tmf/xtext/Bug297105TestLanguage")) {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/tmf/xtext/Bug297105TestLanguage", org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Bug297105TestLanguagePackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bug297105testlanguage", resourceFactory);
		

	}
}
