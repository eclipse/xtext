
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleBacktrackingBug325745TestLanguageStandaloneSetup extends SimpleBacktrackingBug325745TestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleBacktrackingBug325745TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

