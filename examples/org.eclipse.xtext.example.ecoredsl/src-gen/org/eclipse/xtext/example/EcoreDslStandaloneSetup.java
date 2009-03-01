package org.eclipse.xtext.example;

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
public class EcoreDslStandaloneSetup implements ISetup {

	public static void doSetup() {
		new EcoreDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.example.EcoreDslRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://example.xtext.org/EcoreDsl")) {
		EPackage.Registry.INSTANCE.put("http://example.xtext.org/EcoreDsl", org.eclipse.xtext.example.ecoredsl.EcoredslPackage.eINSTANCE);
	}
	//TODO registration of EValidators should be added here, too

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecoredsl", resourceFactory);
		

	}
}
