package org.eclipse.xtext.lexer.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class BacktrackingLexerTestLanguageLanguage extends AbstractXtextLanguage {

	public static final BacktrackingLexerTestLanguageLanguage INSTANCE = new BacktrackingLexerTestLanguageLanguage();

	private Injector injector;

	private BacktrackingLexerTestLanguageLanguage() {
		super("org.eclipse.xtext.lexer.BacktrackingLexerTestLanguage");
		this.injector = new org.eclipse.xtext.lexer.idea.BacktrackingLexerTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
