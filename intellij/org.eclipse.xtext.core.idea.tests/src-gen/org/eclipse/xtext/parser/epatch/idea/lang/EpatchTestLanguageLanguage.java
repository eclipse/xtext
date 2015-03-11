package org.eclipse.xtext.parser.epatch.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EpatchTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EpatchTestLanguageLanguage INSTANCE = new EpatchTestLanguageLanguage();

	private Injector injector;

	private EpatchTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.epatch.EpatchTestLanguage");
		this.injector = new org.eclipse.xtext.parser.epatch.idea.EpatchTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
