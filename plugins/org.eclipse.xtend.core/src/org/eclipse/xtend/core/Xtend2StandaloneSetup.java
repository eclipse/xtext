
package org.eclipse.xtend.core;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.Xtend2StandaloneSetupGenerated;
import org.eclipse.xtend.core.xtend.Xtend2Package;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;

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

