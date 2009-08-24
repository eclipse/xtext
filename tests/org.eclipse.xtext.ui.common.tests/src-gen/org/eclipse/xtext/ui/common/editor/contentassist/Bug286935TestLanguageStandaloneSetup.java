package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class Bug286935TestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new Bug286935TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.ui.common.editor.contentassist.Bug286935TestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/tmf/tests/2009/bug286935TestLanguage")) {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/tmf/tests/2009/bug286935TestLanguage", org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.Bug286935TestLanguagePackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bug286935testlanguage", resourceFactory);
		

	}
}
