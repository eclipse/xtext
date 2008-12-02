package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.xtext.XtextScopeProvider;

/**
 * used to register components to be used at runtime.
 */
public class XtextRuntimeConfig extends AbstractXtextRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> inherited = super.registrations();
		inherited.addAll(scope(IXtext.SCOPE).with(IScopeProvider.class, XtextScopeProvider.class).registrations());
		return inherited;
	}

}
