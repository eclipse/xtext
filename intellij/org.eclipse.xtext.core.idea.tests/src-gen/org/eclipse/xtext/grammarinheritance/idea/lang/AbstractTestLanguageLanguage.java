package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class AbstractTestLanguageLanguage extends AbstractXtextLanguage {

	public static final AbstractTestLanguageLanguage INSTANCE = new AbstractTestLanguageLanguage();

	private Injector injector;

	private AbstractTestLanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.AbstractTestLanguage");
		this.injector = new org.eclipse.xtext.grammarinheritance.idea.AbstractTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
