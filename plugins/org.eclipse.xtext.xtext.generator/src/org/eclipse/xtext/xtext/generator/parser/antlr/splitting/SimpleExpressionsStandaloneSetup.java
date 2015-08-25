package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class SimpleExpressionsStandaloneSetup extends SimpleExpressionsStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleExpressionsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

