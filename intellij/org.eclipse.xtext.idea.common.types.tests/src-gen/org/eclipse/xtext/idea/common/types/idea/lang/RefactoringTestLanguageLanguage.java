package org.eclipse.xtext.idea.common.types.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class RefactoringTestLanguageLanguage extends AbstractXtextLanguage {

	public static final RefactoringTestLanguageLanguage INSTANCE = new RefactoringTestLanguageLanguage();

	private Injector injector;

	private RefactoringTestLanguageLanguage() {
		super("org.eclipse.xtext.idea.common.types.RefactoringTestLanguage");
		this.injector = new org.eclipse.xtext.idea.common.types.idea.RefactoringTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
