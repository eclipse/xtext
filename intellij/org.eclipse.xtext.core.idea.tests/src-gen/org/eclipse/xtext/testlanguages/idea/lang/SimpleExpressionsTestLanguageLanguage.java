package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SimpleExpressionsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SimpleExpressionsTestLanguageLanguage INSTANCE = new SimpleExpressionsTestLanguageLanguage();

	private Injector injector;

	private SimpleExpressionsTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.SimpleExpressionsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
