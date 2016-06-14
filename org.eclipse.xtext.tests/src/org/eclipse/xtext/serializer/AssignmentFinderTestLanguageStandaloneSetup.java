
package org.eclipse.xtext.serializer;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class AssignmentFinderTestLanguageStandaloneSetup extends AssignmentFinderTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new AssignmentFinderTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

