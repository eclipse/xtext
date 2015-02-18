package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class PartialSerializationTestLanguageLanguage extends AbstractXtextLanguage {

	public static final PartialSerializationTestLanguageLanguage INSTANCE = new PartialSerializationTestLanguageLanguage();

	private Injector injector;

	private PartialSerializationTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.PartialSerializationTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.PartialSerializationTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
