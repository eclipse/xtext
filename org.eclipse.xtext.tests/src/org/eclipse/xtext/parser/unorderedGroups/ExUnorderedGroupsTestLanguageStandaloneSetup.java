
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExUnorderedGroupsTestLanguageStandaloneSetup extends ExUnorderedGroupsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new ExUnorderedGroupsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

