
package org.eclipse.xtext.metamodelreferencing.tests;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MetamodelRefTestLanguageStandaloneSetup extends MetamodelRefTestLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new MetamodelRefTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

