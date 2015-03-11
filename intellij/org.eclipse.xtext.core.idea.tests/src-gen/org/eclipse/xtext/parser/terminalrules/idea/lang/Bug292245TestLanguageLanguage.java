package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug292245TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug292245TestLanguageLanguage INSTANCE = new Bug292245TestLanguageLanguage();

	private Injector injector;

	private Bug292245TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.Bug292245TestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.Bug292245TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
