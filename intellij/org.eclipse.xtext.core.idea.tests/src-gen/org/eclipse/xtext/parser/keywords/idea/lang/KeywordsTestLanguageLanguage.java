package org.eclipse.xtext.parser.keywords.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class KeywordsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final KeywordsTestLanguageLanguage INSTANCE = new KeywordsTestLanguageLanguage();

	private Injector injector;

	private KeywordsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.keywords.KeywordsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.keywords.idea.KeywordsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
