package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class OptionalEmptyTestLanguageLanguage extends AbstractXtextLanguage {

	public static final OptionalEmptyTestLanguageLanguage INSTANCE = new OptionalEmptyTestLanguageLanguage();

	private Injector injector;

	private OptionalEmptyTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.OptionalEmptyTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
