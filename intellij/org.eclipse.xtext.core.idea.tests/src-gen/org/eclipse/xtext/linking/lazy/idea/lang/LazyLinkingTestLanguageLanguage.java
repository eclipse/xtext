package org.eclipse.xtext.linking.lazy.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class LazyLinkingTestLanguageLanguage extends AbstractXtextLanguage {

	public static final LazyLinkingTestLanguageLanguage INSTANCE = new LazyLinkingTestLanguageLanguage();

	private Injector injector;

	private LazyLinkingTestLanguageLanguage() {
		super("org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage");
		this.injector = new org.eclipse.xtext.linking.lazy.idea.LazyLinkingTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
