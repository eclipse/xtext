package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SimpleUnorderedGroupsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SimpleUnorderedGroupsTestLanguageLanguage INSTANCE = new SimpleUnorderedGroupsTestLanguageLanguage();

	private Injector injector;

	private SimpleUnorderedGroupsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.unorderedGroups.SimpleUnorderedGroupsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.unorderedGroups.idea.SimpleUnorderedGroupsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
