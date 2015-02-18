package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SerializationBug269362TestLanguageLanguage extends AbstractXtextLanguage {

	public static final SerializationBug269362TestLanguageLanguage INSTANCE = new SerializationBug269362TestLanguageLanguage();

	private Injector injector;

	private SerializationBug269362TestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.SerializationBug269362TestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.SerializationBug269362TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
