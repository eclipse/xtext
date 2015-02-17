package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class LookaheadTestLanguageLanguage extends AbstractXtextLanguage {

	public static final LookaheadTestLanguageLanguage INSTANCE = new LookaheadTestLanguageLanguage();

	private Injector injector;

	private LookaheadTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.LookaheadTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.LookaheadTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
