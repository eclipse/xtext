package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug317840TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug317840TestLanguageLanguage INSTANCE = new Bug317840TestLanguageLanguage();

	private Injector injector;

	private Bug317840TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.Bug317840TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
