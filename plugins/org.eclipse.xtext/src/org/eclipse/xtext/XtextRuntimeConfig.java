package org.eclipse.xtext;

import java.util.Set;

import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.xtext.XtextLinker;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextScopeProvider;

/**
 * used to register components to be used at runtime.
 */
public class XtextRuntimeConfig extends AbstractXtextRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> inherited = super.registrations();
		inherited.addAll(
				scope(IXtext.SCOPE)
					.with(IScopeProvider.class, XtextScopeProvider.class)
					.with(ILinker.class, XtextLinker.class)
					.with(ILinkingService.class, XtextLinkingService.class)
					.registrations());
		return inherited;
	}

}
