
package org.eclipse.xtext.parser.unorderedGroups;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimpleUnorderedGroupsTestLanguageStandaloneSetup extends SimpleUnorderedGroupsTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new SimpleUnorderedGroupsTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

