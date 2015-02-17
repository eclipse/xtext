package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class AssignmentFinderTestLanguageLanguage extends AbstractXtextLanguage {

	public static final AssignmentFinderTestLanguageLanguage INSTANCE = new AssignmentFinderTestLanguageLanguage();

	private Injector injector;

	private AssignmentFinderTestLanguageLanguage() {
		super("org.eclipse.xtext.serializer.AssignmentFinderTestLanguage");
		this.injector = new org.eclipse.xtext.serializer.idea.AssignmentFinderTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
