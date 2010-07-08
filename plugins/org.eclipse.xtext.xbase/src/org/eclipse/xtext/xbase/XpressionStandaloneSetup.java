
package org.eclipse.xtext.xbase;

import org.eclipse.xtext.xpression.XpressionPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XpressionStandaloneSetup extends XpressionStandaloneSetupGenerated{

	public static void doSetup() {
		new XpressionStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		XpressionPackage.eINSTANCE.getXAssignment();
		return super.createInjectorAndDoEMFRegistration();
	}
}

