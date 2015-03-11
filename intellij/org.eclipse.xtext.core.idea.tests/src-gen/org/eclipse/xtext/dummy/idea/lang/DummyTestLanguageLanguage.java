package org.eclipse.xtext.dummy.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class DummyTestLanguageLanguage extends AbstractXtextLanguage {

	public static final DummyTestLanguageLanguage INSTANCE = new DummyTestLanguageLanguage();

	private Injector injector;

	private DummyTestLanguageLanguage() {
		super("org.eclipse.xtext.dummy.DummyTestLanguage");
		this.injector = new org.eclipse.xtext.dummy.idea.DummyTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
