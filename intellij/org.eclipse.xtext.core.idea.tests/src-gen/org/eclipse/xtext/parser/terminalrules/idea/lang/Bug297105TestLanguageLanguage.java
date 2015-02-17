package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug297105TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug297105TestLanguageLanguage INSTANCE = new Bug297105TestLanguageLanguage();

	private Injector injector;

	private Bug297105TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.Bug297105TestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.Bug297105TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
