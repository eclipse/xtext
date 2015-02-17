package org.eclipse.xtext.enumrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EnumAndReferenceTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EnumAndReferenceTestLanguageLanguage INSTANCE = new EnumAndReferenceTestLanguageLanguage();

	private Injector injector;

	private EnumAndReferenceTestLanguageLanguage() {
		super("org.eclipse.xtext.enumrules.EnumAndReferenceTestLanguage");
		this.injector = new org.eclipse.xtext.enumrules.idea.EnumAndReferenceTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
