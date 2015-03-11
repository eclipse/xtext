package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug302128TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug302128TestLanguageLanguage INSTANCE = new Bug302128TestLanguageLanguage();

	private Injector injector;

	private Bug302128TestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.Bug302128TestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.Bug302128TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
