package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class TestLanguageLanguage extends AbstractXtextLanguage {

	public static final TestLanguageLanguage INSTANCE = new TestLanguageLanguage();

	private Injector injector;

	private TestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.TestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
