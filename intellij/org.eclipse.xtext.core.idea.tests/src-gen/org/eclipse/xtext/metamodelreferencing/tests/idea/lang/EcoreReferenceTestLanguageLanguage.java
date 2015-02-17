package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EcoreReferenceTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EcoreReferenceTestLanguageLanguage INSTANCE = new EcoreReferenceTestLanguageLanguage();

	private Injector injector;

	private EcoreReferenceTestLanguageLanguage() {
		super("org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage");
		this.injector = new org.eclipse.xtext.metamodelreferencing.tests.idea.EcoreReferenceTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
