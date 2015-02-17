package org.eclipse.xtext.generator.ecore.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SubTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SubTestLanguageLanguage INSTANCE = new SubTestLanguageLanguage();

	private Injector injector;

	private SubTestLanguageLanguage() {
		super("org.eclipse.xtext.generator.ecore.SubTestLanguage");
		this.injector = new org.eclipse.xtext.generator.ecore.idea.SubTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
