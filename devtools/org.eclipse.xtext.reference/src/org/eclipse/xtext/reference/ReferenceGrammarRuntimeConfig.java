package org.eclipse.xtext.reference;

import java.util.Set;

/**
 * used to register components to be used at runtime.
 */
public class ReferenceGrammarRuntimeConfig extends AbstractReferenceGrammarRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		// do stuff
		return generated;
	}

}
