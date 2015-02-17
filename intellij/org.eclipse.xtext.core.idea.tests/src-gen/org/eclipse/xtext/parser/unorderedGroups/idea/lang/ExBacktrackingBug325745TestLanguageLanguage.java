package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ExBacktrackingBug325745TestLanguageLanguage extends AbstractXtextLanguage {

	public static final ExBacktrackingBug325745TestLanguageLanguage INSTANCE = new ExBacktrackingBug325745TestLanguageLanguage();

	private Injector injector;

	private ExBacktrackingBug325745TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.unorderedGroups.ExBacktrackingBug325745TestLanguage");
		this.injector = new org.eclipse.xtext.parser.unorderedGroups.idea.ExBacktrackingBug325745TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
