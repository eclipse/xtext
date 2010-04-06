
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UnorderedGroupsTestLanguageStandaloneSetup extends UnorderedGroupsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new UnorderedGroupsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

