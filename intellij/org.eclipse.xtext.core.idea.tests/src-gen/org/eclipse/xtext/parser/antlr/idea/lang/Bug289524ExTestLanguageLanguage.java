package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug289524ExTestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug289524ExTestLanguageLanguage INSTANCE = new Bug289524ExTestLanguageLanguage();

	private Injector injector;

	private Bug289524ExTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug289524ExTestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug289524ExTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
