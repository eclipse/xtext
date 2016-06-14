
package org.eclipse.xtext.linking.lazy;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LazyLinkingTestLanguageStandaloneSetup extends LazyLinkingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new LazyLinkingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

