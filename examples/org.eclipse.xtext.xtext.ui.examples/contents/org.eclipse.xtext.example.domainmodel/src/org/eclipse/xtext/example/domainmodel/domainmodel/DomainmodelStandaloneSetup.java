
package org.eclipse.xtext.example.domainmodel.domainmodel;

import org.eclipse.xtext.example.domainmodel.DomainmodelStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DomainmodelStandaloneSetup extends DomainmodelStandaloneSetupGenerated{

	public static void doSetup() {
		new DomainmodelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

