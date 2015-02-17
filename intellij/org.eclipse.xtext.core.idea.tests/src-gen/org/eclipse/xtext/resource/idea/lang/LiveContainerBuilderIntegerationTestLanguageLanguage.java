package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class LiveContainerBuilderIntegerationTestLanguageLanguage extends AbstractXtextLanguage {

	public static final LiveContainerBuilderIntegerationTestLanguageLanguage INSTANCE = new LiveContainerBuilderIntegerationTestLanguageLanguage();

	private Injector injector;

	private LiveContainerBuilderIntegerationTestLanguageLanguage() {
		super("org.eclipse.xtext.resource.LiveContainerBuilderIntegerationTestLanguage");
		this.injector = new org.eclipse.xtext.resource.idea.LiveContainerBuilderIntegerationTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
