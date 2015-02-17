package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class XtextTerminalsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final XtextTerminalsTestLanguageLanguage INSTANCE = new XtextTerminalsTestLanguageLanguage();

	private Injector injector;

	private XtextTerminalsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.terminalrules.idea.XtextTerminalsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
