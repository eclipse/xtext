package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug289059TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug289059TestLanguageLanguage INSTANCE = new Bug289059TestLanguageLanguage();

	private Injector injector;

	private Bug289059TestLanguageLanguage() {
		super("org.eclipse.xtext.linking.Bug289059TestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.Bug289059TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
