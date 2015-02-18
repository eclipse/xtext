package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug299395TestLanguageLanguage extends AbstractXtextLanguage {

	public static final Bug299395TestLanguageLanguage INSTANCE = new Bug299395TestLanguageLanguage();

	private Injector injector;

	private Bug299395TestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.Bug299395TestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.Bug299395TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
