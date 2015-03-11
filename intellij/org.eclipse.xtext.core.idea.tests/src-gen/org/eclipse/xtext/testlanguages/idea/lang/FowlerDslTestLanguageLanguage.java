package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class FowlerDslTestLanguageLanguage extends AbstractXtextLanguage {

	public static final FowlerDslTestLanguageLanguage INSTANCE = new FowlerDslTestLanguageLanguage();

	private Injector injector;

	private FowlerDslTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.FowlerDslTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.FowlerDslTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
