package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class UnassignedRuleCallTestLanguageLanguage extends AbstractXtextLanguage {

	public static final UnassignedRuleCallTestLanguageLanguage INSTANCE = new UnassignedRuleCallTestLanguageLanguage();

	private Injector injector;

	private UnassignedRuleCallTestLanguageLanguage() {
		super("org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTestLanguage");
		this.injector = new org.eclipse.xtext.xtext.ecoreInference.idea.UnassignedRuleCallTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
