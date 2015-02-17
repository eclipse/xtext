package org.eclipse.xtext.parser.assignments.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class AssignmentsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final AssignmentsTestLanguageLanguage INSTANCE = new AssignmentsTestLanguageLanguage();

	private Injector injector;

	private AssignmentsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.assignments.AssignmentsTestLanguage");
		this.injector = new org.eclipse.xtext.parser.assignments.idea.AssignmentsTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
