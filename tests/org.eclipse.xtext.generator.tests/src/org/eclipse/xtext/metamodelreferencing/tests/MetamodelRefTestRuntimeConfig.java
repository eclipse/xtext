package org.eclipse.xtext.metamodelreferencing.tests;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class MetamodelRefTestRuntimeConfig extends AbstractMetamodelRefTestRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		// do stuff 
		return generated;
	}

}
			
