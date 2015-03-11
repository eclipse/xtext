package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SerializationErrorTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SerializationErrorTestLanguageLanguage INSTANCE = new SerializationErrorTestLanguageLanguage();

	private Injector injector;

	private SerializationErrorTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.SerializationErrorTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
