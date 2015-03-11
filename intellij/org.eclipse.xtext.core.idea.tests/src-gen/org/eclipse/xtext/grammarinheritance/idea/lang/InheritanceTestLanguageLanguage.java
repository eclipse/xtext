package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class InheritanceTestLanguageLanguage extends AbstractXtextLanguage {

	public static final InheritanceTestLanguageLanguage INSTANCE = new InheritanceTestLanguageLanguage();

	private Injector injector;

	private InheritanceTestLanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.InheritanceTestLanguage");
		this.injector = new org.eclipse.xtext.grammarinheritance.idea.InheritanceTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
