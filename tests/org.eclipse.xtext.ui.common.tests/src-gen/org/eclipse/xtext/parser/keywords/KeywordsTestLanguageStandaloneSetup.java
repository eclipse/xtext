package org.eclipse.xtext.parser.keywords;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class KeywordsTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new KeywordsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2009/xtext/ui/common/tests/KeywordsTestLanguage")) {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2009/xtext/ui/common/tests/KeywordsTestLanguage", org.eclipse.xtext.parser.keywords.keywordsTestLanguage.KeywordsTestLanguagePackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("keywordstestlanguage", resourceFactory);
		

	}
}
