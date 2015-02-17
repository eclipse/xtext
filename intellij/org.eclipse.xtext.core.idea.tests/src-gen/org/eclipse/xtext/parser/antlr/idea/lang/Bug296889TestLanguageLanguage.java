package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug296889TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug296889TestLanguageLanguage INSTANCE = new Bug296889TestLanguageLanguage();

	private Injector injector;

	private Bug296889TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug296889TestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug296889TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
