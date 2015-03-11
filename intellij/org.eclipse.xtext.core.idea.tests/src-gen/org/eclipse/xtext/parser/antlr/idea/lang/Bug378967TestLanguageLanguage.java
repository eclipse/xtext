package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug378967TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug378967TestLanguageLanguage INSTANCE = new Bug378967TestLanguageLanguage();

	private Injector injector;

	private Bug378967TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug378967TestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug378967TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
