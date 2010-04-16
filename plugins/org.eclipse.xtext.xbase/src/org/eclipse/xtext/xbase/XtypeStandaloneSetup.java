
package org.eclipse.xtext.xbase;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XtypeStandaloneSetup extends XtypeStandaloneSetupGenerated{

	public static void doSetup() {
		new XtypeStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

