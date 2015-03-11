package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SimpleBeeLangTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SimpleBeeLangTestLanguageLanguage INSTANCE = new SimpleBeeLangTestLanguageLanguage();

	private Injector injector;

	private SimpleBeeLangTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.backtracking.idea.SimpleBeeLangTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
