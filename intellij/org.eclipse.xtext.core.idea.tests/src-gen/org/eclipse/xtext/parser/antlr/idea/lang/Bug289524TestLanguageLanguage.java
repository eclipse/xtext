package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug289524TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug289524TestLanguageLanguage INSTANCE = new Bug289524TestLanguageLanguage();

	private Injector injector;

	private Bug289524TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.antlr.Bug289524TestLanguage");
		this.injector = new org.eclipse.xtext.parser.antlr.idea.Bug289524TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
