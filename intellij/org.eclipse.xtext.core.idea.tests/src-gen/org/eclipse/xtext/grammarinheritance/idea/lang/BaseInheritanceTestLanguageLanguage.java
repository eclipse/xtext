package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class BaseInheritanceTestLanguageLanguage extends AbstractXtextLanguage {

	public static final BaseInheritanceTestLanguageLanguage INSTANCE = new BaseInheritanceTestLanguageLanguage();

	private Injector injector;

	private BaseInheritanceTestLanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguage");
		this.injector = new org.eclipse.xtext.grammarinheritance.idea.BaseInheritanceTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
