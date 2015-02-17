package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class BacktrackingBug325745TestLanguageLanguage extends AbstractXtextLanguage {

	public static final BacktrackingBug325745TestLanguageLanguage INSTANCE = new BacktrackingBug325745TestLanguageLanguage();

	private Injector injector;

	private BacktrackingBug325745TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguage");
		this.injector = new org.eclipse.xtext.parser.unorderedGroups.idea.BacktrackingBug325745TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
