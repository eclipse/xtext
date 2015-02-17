package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug289515TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug289515TestLanguageLanguage INSTANCE = new Bug289515TestLanguageLanguage();

	private Injector injector;

	private Bug289515TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug289515TestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug289515TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
