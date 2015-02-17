package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EcoreTerminalsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EcoreTerminalsTestLanguageLanguage INSTANCE = new EcoreTerminalsTestLanguageLanguage();

	private Injector injector;

	private EcoreTerminalsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.EcoreTerminalsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.EcoreTerminalsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
