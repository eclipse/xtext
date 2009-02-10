/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues;

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
public class TransientValuesTestStandaloneSetup implements ISetup {

	public static void doSetup() {
		new TransientValuesTestStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.parsetree.transientvalues.TransientValuesTestRuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("transientvaluestest", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://simple/transientvaluestest")) {
			EPackage transientvaluestest = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/parsetree/transientvalues/transientvaluestest.ecore",
				TransientValuesTestStandaloneSetup.class.getClassLoader());
			if (transientvaluestest == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/parsetree/transientvalues/transientvaluestest.ecore'");
			EPackage.Registry.INSTANCE.put("http://simple/transientvaluestest", transientvaluestest);
		}
	}
	
}
