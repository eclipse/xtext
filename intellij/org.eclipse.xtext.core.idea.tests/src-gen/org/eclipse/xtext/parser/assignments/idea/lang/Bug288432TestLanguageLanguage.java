package org.eclipse.xtext.parser.assignments.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug288432TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug288432TestLanguageLanguage INSTANCE = new Bug288432TestLanguageLanguage();

	private Injector injector;

	private Bug288432TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.assignments.Bug288432TestLanguage");
		this.injector = new org.eclipse.xtext.parser.assignments.idea.Bug288432TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
