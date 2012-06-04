
package de.itemis.statefullexer.simpletemplate;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleTemplateStandaloneSetup extends SimpleTemplateStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleTemplateStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

