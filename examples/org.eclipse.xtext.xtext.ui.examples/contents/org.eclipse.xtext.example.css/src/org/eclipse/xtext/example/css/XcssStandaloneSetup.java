
package org.eclipse.xtext.example.css;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XcssStandaloneSetup extends XcssStandaloneSetupGenerated{

	public static void doSetup() {
		new XcssStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

