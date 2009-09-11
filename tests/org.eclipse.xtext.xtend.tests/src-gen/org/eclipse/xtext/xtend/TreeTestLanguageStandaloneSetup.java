package org.eclipse.xtext.xtend;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class TreeTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new TreeTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.xtend.TreeTestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/2008/xtext/xtendtests/TreeTestLanguage")) {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/2008/xtext/xtendtests/TreeTestLanguage", org.eclipse.xtext.xtend.treeXtendTestLanguage.TreeXtendTestLanguagePackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("treetestlanguage", resourceFactory);
		
	//TODO registration of EValidators should be added here, too

	}
}
