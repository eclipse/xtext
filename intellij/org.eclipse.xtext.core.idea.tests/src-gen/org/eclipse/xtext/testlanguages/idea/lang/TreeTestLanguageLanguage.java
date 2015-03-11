package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class TreeTestLanguageLanguage extends AbstractXtextLanguage {

	public static final TreeTestLanguageLanguage INSTANCE = new TreeTestLanguageLanguage();

	private Injector injector;

	private TreeTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.TreeTestLanguage");
		this.injector = new org.eclipse.xtext.testlanguages.idea.TreeTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
