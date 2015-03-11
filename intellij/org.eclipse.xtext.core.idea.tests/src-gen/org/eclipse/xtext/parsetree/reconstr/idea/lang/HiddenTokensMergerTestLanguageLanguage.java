package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class HiddenTokensMergerTestLanguageLanguage extends AbstractXtextLanguage {

	public static final HiddenTokensMergerTestLanguageLanguage INSTANCE = new HiddenTokensMergerTestLanguageLanguage();

	private Injector injector;

	private HiddenTokensMergerTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.reconstr.idea.HiddenTokensMergerTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
