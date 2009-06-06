package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
public class SimpleReconstrTestLanguageStandaloneSetup implements ISetup {

	public static void doSetup() {
		new SimpleReconstrTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguageRuntimeModule());
	}
	
	public void register(Injector injector) {

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("simplereconstrtestlanguage", resourceFactory);
		
	if (!EPackage.Registry.INSTANCE.containsKey("http://simple/rewrite/test")) {
		EPackage.Registry.INSTANCE.put("http://simple/rewrite/test", org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage.eINSTANCE);
	}

	}
}
