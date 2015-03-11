package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug299237TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug299237TestLanguageLanguage INSTANCE = new Bug299237TestLanguageLanguage();

	private Injector injector;

	private Bug299237TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug299237TestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug299237TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
