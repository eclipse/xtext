package org.eclipse.xtext.valueconverter;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class Bug250313RuntimeConfig extends AbstractBug250313RuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		// do stuff 
		return generated;
	}

}
			
