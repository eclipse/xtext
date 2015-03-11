package org.eclipse.xtext.valueconverter.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class QualifiedNameTestLanguageLanguage extends AbstractXtextLanguage {

	public static final QualifiedNameTestLanguageLanguage INSTANCE = new QualifiedNameTestLanguageLanguage();

	private Injector injector;

	private QualifiedNameTestLanguageLanguage() {
		super("org.eclipse.xtext.valueconverter.QualifiedNameTestLanguage");
		this.injector = new org.eclipse.xtext.valueconverter.idea.QualifiedNameTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
