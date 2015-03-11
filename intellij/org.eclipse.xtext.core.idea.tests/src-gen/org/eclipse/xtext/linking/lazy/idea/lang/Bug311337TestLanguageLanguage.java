package org.eclipse.xtext.linking.lazy.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug311337TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug311337TestLanguageLanguage INSTANCE = new Bug311337TestLanguageLanguage();

	private Injector injector;

	private Bug311337TestLanguageLanguage() {
		super("org.eclipse.xtext.linking.lazy.Bug311337TestLanguage");
		this.injector = new org.eclipse.xtext.linking.lazy.idea.Bug311337TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
