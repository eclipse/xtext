package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EObjectAtOffsetTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EObjectAtOffsetTestLanguageLanguage INSTANCE = new EObjectAtOffsetTestLanguageLanguage();

	private Injector injector;

	private EObjectAtOffsetTestLanguageLanguage() {
		super("org.eclipse.xtext.resource.EObjectAtOffsetTestLanguage");
		this.injector = new org.eclipse.xtext.resource.idea.EObjectAtOffsetTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
