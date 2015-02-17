package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class InheritanceTest2LanguageLanguage extends AbstractXtextLanguage {

	public static final InheritanceTest2LanguageLanguage INSTANCE = new InheritanceTest2LanguageLanguage();

	private Injector injector;

	private InheritanceTest2LanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.InheritanceTest2Language");
		this.injector = new org.eclipse.xtext.grammarinheritance.idea.InheritanceTest2LanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
