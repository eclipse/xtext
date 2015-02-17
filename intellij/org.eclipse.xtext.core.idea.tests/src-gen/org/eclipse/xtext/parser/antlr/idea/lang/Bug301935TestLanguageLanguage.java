package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug301935TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug301935TestLanguageLanguage INSTANCE = new Bug301935TestLanguageLanguage();

	private Injector injector;

	private Bug301935TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug301935TestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug301935TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
