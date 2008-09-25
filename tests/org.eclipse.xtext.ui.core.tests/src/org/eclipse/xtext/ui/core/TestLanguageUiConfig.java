package org.eclipse.xtext.ui.core;

import java.util.Set;

import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;
import org.eclipse.xtext.ui.core.editor.XtextSourceViewerConfiguration;

/**
 * used to register components to be used at runtime.
 */
public class TestLanguageUiConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(org.eclipse.xtext.ui.core.ITestLanguage.SCOPE)
		.with(XtextSourceViewerConfiguration.class).registrations();
	}

}
