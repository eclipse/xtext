package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug287988TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug287988TestLanguageLanguage INSTANCE = new Bug287988TestLanguageLanguage();

	private Injector injector;

	private Bug287988TestLanguageLanguage() {
		super("org.eclipse.xtext.linking.Bug287988TestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.Bug287988TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
