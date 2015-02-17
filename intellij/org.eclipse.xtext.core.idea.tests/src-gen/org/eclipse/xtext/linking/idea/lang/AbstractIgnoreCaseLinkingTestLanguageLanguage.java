package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class AbstractIgnoreCaseLinkingTestLanguageLanguage extends AbstractXtextLanguage {

	public static final AbstractIgnoreCaseLinkingTestLanguageLanguage INSTANCE = new AbstractIgnoreCaseLinkingTestLanguageLanguage();

	private Injector injector;

	private AbstractIgnoreCaseLinkingTestLanguageLanguage() {
		super("org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
