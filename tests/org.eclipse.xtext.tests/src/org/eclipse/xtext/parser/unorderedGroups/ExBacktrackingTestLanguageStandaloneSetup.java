
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExBacktrackingTestLanguageStandaloneSetup extends ExBacktrackingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ExBacktrackingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

