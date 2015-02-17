package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class MetamodelRefTestLanguageLanguage extends AbstractXtextLanguage {

	public static final MetamodelRefTestLanguageLanguage INSTANCE = new MetamodelRefTestLanguageLanguage();

	private Injector injector;

	private MetamodelRefTestLanguageLanguage() {
		super("org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguage");
		this.injector = new org.eclipse.xtext.metamodelreferencing.tests.idea.MetamodelRefTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
