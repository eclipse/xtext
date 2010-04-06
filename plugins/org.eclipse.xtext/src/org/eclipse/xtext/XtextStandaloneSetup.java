
package org.eclipse.xtext;

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
		XtextPackage.eINSTANCE.getAbstractElement();
		super.register(injector);
	}
}

