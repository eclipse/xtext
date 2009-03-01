package org.eclipse.xtext.reference;

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
public class ReferenceGrammarStandaloneSetup implements ISetup {

	public static void doSetup() {
		new ReferenceGrammarStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public Injector createInjectorAndDoEMFRegistration() {
		
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.xtext.reference.ReferenceGrammarRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/reference/ReferenceGrammar")) {
		EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/reference/ReferenceGrammar", org.eclipse.xtext.reference.referenceGrammar.ReferenceGrammarPackage.eINSTANCE);
	}
	//TODO registration of EValidators should be added here, too

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtest", resourceFactory);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tst", resourceFactory);
		

	}
}
