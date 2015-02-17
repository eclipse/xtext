package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug443221TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug443221TestLanguageLanguage INSTANCE = new Bug443221TestLanguageLanguage();

	private Injector injector;

	private Bug443221TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug443221TestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug443221TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
