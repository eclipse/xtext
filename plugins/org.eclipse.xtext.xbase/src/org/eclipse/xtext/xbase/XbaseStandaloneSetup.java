
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XbaseStandaloneSetup extends XbaseStandaloneSetupGenerated{

	public static void doSetup() {
		new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		EPackage.Registry.INSTANCE.put(XbasePackage.eINSTANCE.getNsURI(),XbasePackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}
}

