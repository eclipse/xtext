package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SimpleReconstrTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SimpleReconstrTestLanguageLanguage INSTANCE = new SimpleReconstrTestLanguageLanguage();

	private Injector injector;

	private SimpleReconstrTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.SimpleReconstrTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
