package org.eclipse.xtext.lexer.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class IgnoreCaseLexerTestLanguageLanguage extends AbstractXtextLanguage {

	public static final IgnoreCaseLexerTestLanguageLanguage INSTANCE = new IgnoreCaseLexerTestLanguageLanguage();

	private Injector injector;

	private IgnoreCaseLexerTestLanguageLanguage() {
		super("org.eclipse.xtext.lexer.IgnoreCaseLexerTestLanguage");
		this.injector = new org.eclipse.xtext.lexer.idea.IgnoreCaseLexerTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
