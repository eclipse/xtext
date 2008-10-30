package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;

/**
 * used to register components to be used at runtime.
 */
public class XtextGrammarTestRuntimeConfig extends AbstractXtextGrammarTestRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		// do stuff 
		return generated;
	}

}
			
