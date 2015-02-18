package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class UnorderedGroupsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final UnorderedGroupsTestLanguageLanguage INSTANCE = new UnorderedGroupsTestLanguageLanguage();

	private Injector injector;

	private UnorderedGroupsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.unorderedGroups.UnorderedGroupsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.unorderedGroups.idea.UnorderedGroupsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
