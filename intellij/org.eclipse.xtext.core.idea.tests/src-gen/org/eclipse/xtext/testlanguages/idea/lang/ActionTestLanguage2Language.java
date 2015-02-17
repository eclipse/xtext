package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ActionTestLanguage2Language extends AbstractXtextLanguage {

	public static final ActionTestLanguage2Language INSTANCE = new ActionTestLanguage2Language();

	private Injector injector;

	private ActionTestLanguage2Language() {
		super("org.eclipse.xtext.testlanguages.ActionTestLanguage2");
		this.injector = new org.eclipse.xtext.testlanguages.idea.ActionTestLanguage2StandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
