package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class HiddenTerminalsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final HiddenTerminalsTestLanguageLanguage INSTANCE = new HiddenTerminalsTestLanguageLanguage();

	private Injector injector;

	private HiddenTerminalsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.HiddenTerminalsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
