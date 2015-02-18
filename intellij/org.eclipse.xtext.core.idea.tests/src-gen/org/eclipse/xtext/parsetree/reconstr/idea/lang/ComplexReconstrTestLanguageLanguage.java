package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ComplexReconstrTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ComplexReconstrTestLanguageLanguage INSTANCE = new ComplexReconstrTestLanguageLanguage();

	private Injector injector;

	private ComplexReconstrTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.ComplexReconstrTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
