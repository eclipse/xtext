
package org.eclipse.xtext.generator.parser.antlr.splitting;

import org.eclipse.xtext.generator.parser.antlr.splitting.SimpleExpressionsStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleExpressionsStandaloneSetup extends SimpleExpressionsStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleExpressionsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

