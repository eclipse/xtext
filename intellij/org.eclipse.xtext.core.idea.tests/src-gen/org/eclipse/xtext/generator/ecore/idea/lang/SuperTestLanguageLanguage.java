package org.eclipse.xtext.generator.ecore.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SuperTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SuperTestLanguageLanguage INSTANCE = new SuperTestLanguageLanguage();

	private Injector injector;

	private SuperTestLanguageLanguage() {
		super("org.eclipse.xtext.generator.ecore.SuperTestLanguage");
		this.injector = new org.eclipse.xtext.generator.ecore.idea.SuperTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
