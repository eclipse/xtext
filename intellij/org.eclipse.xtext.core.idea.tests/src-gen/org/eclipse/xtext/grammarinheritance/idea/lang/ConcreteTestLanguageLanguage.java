package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ConcreteTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ConcreteTestLanguageLanguage INSTANCE = new ConcreteTestLanguageLanguage();

	private Injector injector;

	private ConcreteTestLanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage");
		this.injector = new org.eclipse.xtext.grammarinheritance.idea.ConcreteTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
