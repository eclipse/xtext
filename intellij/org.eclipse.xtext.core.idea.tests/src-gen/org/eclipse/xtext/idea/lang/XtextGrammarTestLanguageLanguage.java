package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class XtextGrammarTestLanguageLanguage extends AbstractXtextLanguage {

	public static final XtextGrammarTestLanguageLanguage INSTANCE = new XtextGrammarTestLanguageLanguage();

	private Injector injector;

	private XtextGrammarTestLanguageLanguage() {
		super("org.eclipse.xtext.XtextGrammarTestLanguage");
		this.injector = new org.eclipse.xtext.idea.XtextGrammarTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
