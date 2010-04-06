
package org.eclipse.xtext.parsetree.formatter;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FormatterTestLanguageStandaloneSetup extends FormatterTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new FormatterTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

