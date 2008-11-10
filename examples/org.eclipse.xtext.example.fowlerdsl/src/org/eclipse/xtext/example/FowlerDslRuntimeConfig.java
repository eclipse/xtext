package org.eclipse.xtext.example;

import java.util.Set;

/**
 * used to register components to be used at runtime.
 */
public class FowlerDslRuntimeConfig extends AbstractFowlerDslRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		// do stuff 
		return generated;
	}

}
			
