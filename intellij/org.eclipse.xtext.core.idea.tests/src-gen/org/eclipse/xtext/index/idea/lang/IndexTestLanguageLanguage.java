package org.eclipse.xtext.index.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class IndexTestLanguageLanguage extends AbstractXtextLanguage {

	public static final IndexTestLanguageLanguage INSTANCE = new IndexTestLanguageLanguage();

	private Injector injector;

	private IndexTestLanguageLanguage() {
		super("org.eclipse.xtext.index.IndexTestLanguage");
		this.injector = new org.eclipse.xtext.index.idea.IndexTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
