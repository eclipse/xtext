package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class UnicodeCharacterTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new UnicodeCharacterTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(/*new org.eclipse.xtext.parser.UnicodeCharacterTestLanguageRuntimeModule()*/);
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/xtext/test/unicodeChars")) {
//		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/test/unicodeChars", org.eclipse.xtext.parser.unicodeTest.UnicodeTestPackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("unicodecharactertestlanguage", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("unicodecharactertestlanguage", serviceProvider);
		

	}
}
