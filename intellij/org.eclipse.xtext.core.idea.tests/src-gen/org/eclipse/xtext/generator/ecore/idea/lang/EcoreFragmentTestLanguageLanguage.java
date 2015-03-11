package org.eclipse.xtext.generator.ecore.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EcoreFragmentTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EcoreFragmentTestLanguageLanguage INSTANCE = new EcoreFragmentTestLanguageLanguage();

	private Injector injector;

	private EcoreFragmentTestLanguageLanguage() {
		super("org.eclipse.xtext.generator.ecore.EcoreFragmentTestLanguage");
		this.injector = new org.eclipse.xtext.generator.ecore.idea.EcoreFragmentTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
