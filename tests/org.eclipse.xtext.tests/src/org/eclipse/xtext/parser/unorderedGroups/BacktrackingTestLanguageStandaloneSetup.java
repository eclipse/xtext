
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BacktrackingTestLanguageStandaloneSetup extends BacktrackingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BacktrackingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

