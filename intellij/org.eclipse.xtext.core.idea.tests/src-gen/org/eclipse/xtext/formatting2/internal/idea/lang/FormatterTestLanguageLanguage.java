package org.eclipse.xtext.formatting2.internal.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class FormatterTestLanguageLanguage extends AbstractXtextLanguage {

	public static final FormatterTestLanguageLanguage INSTANCE = new FormatterTestLanguageLanguage();

	private Injector injector;

	private FormatterTestLanguageLanguage() {
		super("org.eclipse.xtext.formatting2.internal.FormatterTestLanguage");
		this.injector = new org.eclipse.xtext.formatting2.internal.idea.FormatterTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
