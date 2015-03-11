package org.eclipse.xtext.idea.example.entities.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class EntitiesLanguage extends AbstractXtextLanguage {

	public static final EntitiesLanguage INSTANCE = new EntitiesLanguage();

	private Injector injector;

	private EntitiesLanguage() {
		super("org.eclipse.xtext.idea.example.entities.Entities");
		this.injector = new org.eclipse.xtext.idea.example.entities.idea.EntitiesStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
