package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class PartialParserTestLanguageLanguage extends AbstractXtextLanguage {

	public static final PartialParserTestLanguageLanguage INSTANCE = new PartialParserTestLanguageLanguage();

	private Injector injector;

	private PartialParserTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.PartialParserTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.PartialParserTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
