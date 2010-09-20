
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EPackage;
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
		new XtypeStandaloneSetup().createInjectorAndDoEMFRegistration();
		EPackage.Registry.INSTANCE.put(XpressionPackage.eINSTANCE.getNsURI(),XpressionPackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}
}

