package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ExBeeLangTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ExBeeLangTestLanguageLanguage INSTANCE = new ExBeeLangTestLanguageLanguage();

	private Injector injector;

	private ExBeeLangTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.backtracking.ExBeeLangTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.backtracking.idea.ExBeeLangTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
