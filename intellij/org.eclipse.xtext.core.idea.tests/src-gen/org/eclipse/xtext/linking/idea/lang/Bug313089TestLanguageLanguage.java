package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug313089TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug313089TestLanguageLanguage INSTANCE = new Bug313089TestLanguageLanguage();

	private Injector injector;

	private Bug313089TestLanguageLanguage() {
		super("org.eclipse.xtext.linking.Bug313089TestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.Bug313089TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
