package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * used to register components to be used at runtime.
 */
public class XtextGrammarTestLanguageRuntimeConfig extends AbstractXtextGrammarTestLanguageRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		// do stuff 
		return generated;
	}

}
			
