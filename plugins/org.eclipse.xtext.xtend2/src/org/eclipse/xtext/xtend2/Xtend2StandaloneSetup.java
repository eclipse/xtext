
package org.eclipse.xtext.xtend2;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Xtend2StandaloneSetup extends Xtend2StandaloneSetupGenerated{
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		EPackage.Registry.INSTANCE.put(Xtend2Package.eINSTANCE.getNsURI(),Xtend2Package.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}

	public static void doSetup() {
		new Xtend2StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

