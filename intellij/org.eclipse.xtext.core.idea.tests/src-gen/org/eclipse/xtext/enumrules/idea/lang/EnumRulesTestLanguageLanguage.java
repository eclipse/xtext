package org.eclipse.xtext.enumrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EnumRulesTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EnumRulesTestLanguageLanguage INSTANCE = new EnumRulesTestLanguageLanguage();

	private Injector injector;

	private EnumRulesTestLanguageLanguage() {
		super("org.eclipse.xtext.enumrules.EnumRulesTestLanguage");
		this.injector = new org.eclipse.xtext.enumrules.idea.EnumRulesTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
