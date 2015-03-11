package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class LangATestLanguageLanguage extends AbstractXtextLanguage {

	public static final LangATestLanguageLanguage INSTANCE = new LangATestLanguageLanguage();

	private Injector injector;

	private LangATestLanguageLanguage() {
		super("org.eclipse.xtext.linking.LangATestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.LangATestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
