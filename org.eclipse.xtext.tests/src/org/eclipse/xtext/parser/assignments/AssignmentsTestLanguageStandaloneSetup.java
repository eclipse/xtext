
package org.eclipse.xtext.parser.assignments;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class AssignmentsTestLanguageStandaloneSetup extends AssignmentsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new AssignmentsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

