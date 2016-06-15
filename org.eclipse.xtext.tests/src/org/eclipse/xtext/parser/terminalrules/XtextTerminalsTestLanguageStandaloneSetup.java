
package org.eclipse.xtext.parser.terminalrules;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XtextTerminalsTestLanguageStandaloneSetup extends XtextTerminalsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new XtextTerminalsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

