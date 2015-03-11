package org.eclipse.xtext.testlanguages.indent.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class IndentationAwareTestLanguageLanguage extends AbstractXtextLanguage {

	public static final IndentationAwareTestLanguageLanguage INSTANCE = new IndentationAwareTestLanguageLanguage();

	private Injector injector;

	private IndentationAwareTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.indent.idea.IndentationAwareTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
