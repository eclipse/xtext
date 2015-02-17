package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ContextFinderTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ContextFinderTestLanguageLanguage INSTANCE = new ContextFinderTestLanguageLanguage();

	private Injector injector;

	private ContextFinderTestLanguageLanguage() {
		super("org.eclipse.xtext.serializer.ContextFinderTestLanguage");
		this.injector = new org.eclipse.xtext.serializer.idea.ContextFinderTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
