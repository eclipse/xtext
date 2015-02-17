package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ImportUriTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ImportUriTestLanguageLanguage INSTANCE = new ImportUriTestLanguageLanguage();

	private Injector injector;

	private ImportUriTestLanguageLanguage() {
		super("org.eclipse.xtext.linking.ImportUriTestLanguage");
		this.injector = new org.eclipse.xtext.linking.idea.ImportUriTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
