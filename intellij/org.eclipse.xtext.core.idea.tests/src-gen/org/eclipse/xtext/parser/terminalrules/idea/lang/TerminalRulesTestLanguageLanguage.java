package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class TerminalRulesTestLanguageLanguage extends AbstractXtextLanguage {

	public static final TerminalRulesTestLanguageLanguage INSTANCE = new TerminalRulesTestLanguageLanguage();

	private Injector injector;

	private TerminalRulesTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.TerminalRulesTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
