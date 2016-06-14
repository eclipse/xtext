
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XtextStandaloneSetup extends XtextStandaloneSetupGenerated{

	public static void doSetup() {
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		EPackage.Registry.INSTANCE.put(XtextPackage.eINSTANCE.getNsURI(), XtextPackage.eINSTANCE);
		super.register(injector);
	}
}

