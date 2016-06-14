
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BacktrackingBug325745TestLanguageStandaloneSetup extends BacktrackingBug325745TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new BacktrackingBug325745TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

