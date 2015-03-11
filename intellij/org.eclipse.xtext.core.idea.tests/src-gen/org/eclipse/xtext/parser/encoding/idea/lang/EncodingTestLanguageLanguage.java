package org.eclipse.xtext.parser.encoding.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EncodingTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EncodingTestLanguageLanguage INSTANCE = new EncodingTestLanguageLanguage();

	private Injector injector;

	private EncodingTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.encoding.EncodingTestLanguage");
		this.injector = new org.eclipse.xtext.parser.encoding.idea.EncodingTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
