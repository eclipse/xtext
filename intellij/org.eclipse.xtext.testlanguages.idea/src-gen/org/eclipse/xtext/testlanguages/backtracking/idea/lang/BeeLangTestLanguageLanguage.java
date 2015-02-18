package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class BeeLangTestLanguageLanguage extends AbstractXtextLanguage {

	public static final BeeLangTestLanguageLanguage INSTANCE = new BeeLangTestLanguageLanguage();

	private Injector injector;

	private BeeLangTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.backtracking.idea.BeeLangTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
