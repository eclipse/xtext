
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleBacktrackingTestLanguageStandaloneSetup extends SimpleBacktrackingTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleBacktrackingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

