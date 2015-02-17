package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class UnicodeTestLanguageLanguage extends AbstractXtextLanguage {

	public static final UnicodeTestLanguageLanguage INSTANCE = new UnicodeTestLanguageLanguage();

	private Injector injector;

	private UnicodeTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.UnicodeTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
