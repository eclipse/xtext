package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class IgnoreCaseNamespacesTestLanguageLanguage extends AbstractXtextLanguage {

	public static final IgnoreCaseNamespacesTestLanguageLanguage INSTANCE = new IgnoreCaseNamespacesTestLanguageLanguage();

	private Injector injector;

	private IgnoreCaseNamespacesTestLanguageLanguage() {
		super("org.eclipse.xtext.linking.IgnoreCaseNamespacesTestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.IgnoreCaseNamespacesTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
