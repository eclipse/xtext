package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SimpleBacktrackingBug325745TestLanguageLanguage extends AbstractXtextLanguage {

	public static final SimpleBacktrackingBug325745TestLanguageLanguage INSTANCE = new SimpleBacktrackingBug325745TestLanguageLanguage();

	private Injector injector;

	private SimpleBacktrackingBug325745TestLanguageLanguage() {
		super("org.eclipse.xtext.parser.unorderedGroups.SimpleBacktrackingBug325745TestLanguage");
		this.injector = new org.eclipse.xtext.parser.unorderedGroups.idea.SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
