package org.eclipse.xtext.parser.assignments.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug287184TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug287184TestLanguageLanguage INSTANCE = new Bug287184TestLanguageLanguage();

	private Injector injector;

	private Bug287184TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.assignments.Bug287184TestLanguage");
		this.injector = new org.eclipse.xtext.parser.assignments.idea.Bug287184TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
