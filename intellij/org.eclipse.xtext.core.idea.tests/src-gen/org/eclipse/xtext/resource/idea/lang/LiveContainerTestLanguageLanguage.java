package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class LiveContainerTestLanguageLanguage extends AbstractXtextLanguage {

	public static final LiveContainerTestLanguageLanguage INSTANCE = new LiveContainerTestLanguageLanguage();

	private Injector injector;

	private LiveContainerTestLanguageLanguage() {
		super("org.eclipse.xtext.resource.LiveContainerTestLanguage");
		this.injector = new org.eclipse.xtext.resource.idea.LiveContainerTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
