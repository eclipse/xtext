package org.eclipse.xtext.parsetree.unassignedtext.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class UnassignedTextTestLanguageLanguage extends AbstractXtextLanguage {

	public static final UnassignedTextTestLanguageLanguage INSTANCE = new UnassignedTextTestLanguageLanguage();

	private Injector injector;

	private UnassignedTextTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.unassignedtext.UnassignedTextTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.unassignedtext.idea.UnassignedTextTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
