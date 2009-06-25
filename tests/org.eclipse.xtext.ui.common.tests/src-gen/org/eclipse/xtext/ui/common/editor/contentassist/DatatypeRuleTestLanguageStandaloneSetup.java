package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class DatatypeRuleTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new DatatypeRuleTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.ui.common.editor.contentassist.DatatypeRuleTestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/tmf/tests/2009/datatypeRuleTest")) {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/tmf/tests/2009/datatypeRuleTest", org.eclipse.xtext.ui.common.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("datatyperuletestlanguage", resourceFactory);
		

	}
}
