package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class ExUnorderedGroupsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ExUnorderedGroupsTestLanguageLanguage INSTANCE = new ExUnorderedGroupsTestLanguageLanguage();

	private Injector injector;

	private ExUnorderedGroupsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.unorderedGroups.ExUnorderedGroupsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.unorderedGroups.idea.ExUnorderedGroupsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
