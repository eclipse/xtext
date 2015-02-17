package org.eclipse.xtext.enumrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class MultiRuleEnumTestLanguageLanguage extends AbstractXtextLanguage {

	public static final MultiRuleEnumTestLanguageLanguage INSTANCE = new MultiRuleEnumTestLanguageLanguage();

	private Injector injector;

	private MultiRuleEnumTestLanguageLanguage() {
		super("org.eclipse.xtext.enumrules.MultiRuleEnumTestLanguage");
		this.injector = new org.eclipse.xtext.enumrules.idea.MultiRuleEnumTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
