package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class MultiValueFeatureTestLanguageLanguage extends AbstractXtextLanguage {

	public static final MultiValueFeatureTestLanguageLanguage INSTANCE = new MultiValueFeatureTestLanguageLanguage();

	private Injector injector;

	private MultiValueFeatureTestLanguageLanguage() {
		super("org.eclipse.xtext.xtext.ecoreInference.MultiValueFeatureTestLanguage");
		this.injector = new org.eclipse.xtext.xtext.ecoreInference.idea.MultiValueFeatureTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
