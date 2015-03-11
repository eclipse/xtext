package org.eclipse.xtext.parser.datatyperules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class DatatypeRulesTestLanguageLanguage extends AbstractXtextLanguage {

	public static final DatatypeRulesTestLanguageLanguage INSTANCE = new DatatypeRulesTestLanguageLanguage();

	private Injector injector;

	private DatatypeRulesTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage");
		this.injector = new org.eclipse.xtext.parser.datatyperules.idea.DatatypeRulesTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
