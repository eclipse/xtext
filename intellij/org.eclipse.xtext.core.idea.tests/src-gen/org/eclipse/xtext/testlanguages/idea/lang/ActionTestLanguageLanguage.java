package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ActionTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ActionTestLanguageLanguage INSTANCE = new ActionTestLanguageLanguage();

	private Injector injector;

	private ActionTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.ActionTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.ActionTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
