package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ReferenceGrammarTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ReferenceGrammarTestLanguageLanguage INSTANCE = new ReferenceGrammarTestLanguageLanguage();

	private Injector injector;

	private ReferenceGrammarTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.ReferenceGrammarTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
