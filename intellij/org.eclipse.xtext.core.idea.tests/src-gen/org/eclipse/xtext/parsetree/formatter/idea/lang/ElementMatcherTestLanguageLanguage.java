package org.eclipse.xtext.parsetree.formatter.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ElementMatcherTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ElementMatcherTestLanguageLanguage INSTANCE = new ElementMatcherTestLanguageLanguage();

	private Injector injector;

	private ElementMatcherTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.formatter.idea.ElementMatcherTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
