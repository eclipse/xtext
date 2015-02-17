package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class MultiGenMMTestLanguageLanguage extends AbstractXtextLanguage {

	public static final MultiGenMMTestLanguageLanguage INSTANCE = new MultiGenMMTestLanguageLanguage();

	private Injector injector;

	private MultiGenMMTestLanguageLanguage() {
		super("org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguage");
		this.injector = new org.eclipse.xtext.metamodelreferencing.tests.idea.MultiGenMMTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
