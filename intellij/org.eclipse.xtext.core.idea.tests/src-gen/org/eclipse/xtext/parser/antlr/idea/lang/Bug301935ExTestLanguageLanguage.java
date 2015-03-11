package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug301935ExTestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug301935ExTestLanguageLanguage INSTANCE = new Bug301935ExTestLanguageLanguage();

	private Injector injector;

	private Bug301935ExTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug301935ExTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
