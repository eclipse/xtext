
package org.eclipse.xtext.generator.parser.antlr.debug;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class SimpleAntlrStandaloneSetup extends SimpleAntlrStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleAntlrStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

