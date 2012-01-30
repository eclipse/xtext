
package org.eclipse.xtend.core;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XtendStandaloneSetup extends XtendStandaloneSetupGenerated{
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		EPackage.Registry.INSTANCE.put(XtendPackage.eINSTANCE.getNsURI(),XtendPackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}

	public static void doSetup() {
		new XtendStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

