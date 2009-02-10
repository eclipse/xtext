/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter;

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
public class Bug250313StandaloneSetup implements ISetup {

	public static void doSetup() {
		new Bug250313StandaloneSetup().createInjectorAndDoEMFRegistration();
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
		return Guice.createInjector(new org.eclipse.xtext.valueconverter.Bug250313RuntimeModule());
	}
	
	public void registerResourceFactory(IResourceFactory resourceFactory) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("bug250313", resourceFactory);
		
	}

	/**
	 * Initializes all EPackages generated for this language and registers them with EPackage.Registry.INSTANCE
	 */	
	public void registerEPackages() {
		if (!EPackage.Registry.INSTANCE.containsKey("http://org.eclipse.xtext.valueconverter.Bug250313")) {
			EPackage bug250313 = EcoreUtil2.loadEPackage(
				"classpath:/org/eclipse/xtext/valueconverter/bug250313.ecore",
				Bug250313StandaloneSetup.class.getClassLoader());
			if (bug250313 == null)
				throw new IllegalStateException(
					"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/valueconverter/bug250313.ecore'");
			EPackage.Registry.INSTANCE.put("http://org.eclipse.xtext.valueconverter.Bug250313", bug250313);
		}
	}
	
}
