package org.eclipse.xtext.generator.grammarAccess.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class GrammarAccessTestLanguageLanguage extends AbstractXtextLanguage {

	public static final GrammarAccessTestLanguageLanguage INSTANCE = new GrammarAccessTestLanguageLanguage();

	private Injector injector;

	private GrammarAccessTestLanguageLanguage() {
		super("org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguage");
		this.injector = new org.eclipse.xtext.generator.grammarAccess.idea.GrammarAccessTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
