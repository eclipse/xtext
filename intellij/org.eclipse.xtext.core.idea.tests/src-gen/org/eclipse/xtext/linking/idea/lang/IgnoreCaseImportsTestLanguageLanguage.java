package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class IgnoreCaseImportsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final IgnoreCaseImportsTestLanguageLanguage INSTANCE = new IgnoreCaseImportsTestLanguageLanguage();

	private Injector injector;

	private IgnoreCaseImportsTestLanguageLanguage() {
		super("org.eclipse.xtext.linking.IgnoreCaseImportsTestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.IgnoreCaseImportsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
