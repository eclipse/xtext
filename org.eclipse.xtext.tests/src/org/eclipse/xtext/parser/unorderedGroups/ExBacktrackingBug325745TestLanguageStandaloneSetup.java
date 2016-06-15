
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExBacktrackingBug325745TestLanguageStandaloneSetup extends ExBacktrackingBug325745TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ExBacktrackingBug325745TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

