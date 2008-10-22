package org.eclipse.xtext.dummy;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class DummyLanguageRuntimeConfig extends AbstractDummyLanguageRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		// do stuff 
		return generated;
	}

}
			
