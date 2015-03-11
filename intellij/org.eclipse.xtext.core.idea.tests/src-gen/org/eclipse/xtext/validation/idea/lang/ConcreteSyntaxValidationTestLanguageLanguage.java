package org.eclipse.xtext.validation.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ConcreteSyntaxValidationTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ConcreteSyntaxValidationTestLanguageLanguage INSTANCE = new ConcreteSyntaxValidationTestLanguageLanguage();

	private Injector injector;

	private ConcreteSyntaxValidationTestLanguageLanguage() {
		super("org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguage");
		this.injector = new org.eclipse.xtext.validation.idea.ConcreteSyntaxValidationTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
