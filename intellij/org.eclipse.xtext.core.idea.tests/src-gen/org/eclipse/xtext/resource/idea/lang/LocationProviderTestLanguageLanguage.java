package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class LocationProviderTestLanguageLanguage extends AbstractXtextLanguage {

	public static final LocationProviderTestLanguageLanguage INSTANCE = new LocationProviderTestLanguageLanguage();

	private Injector injector;

	private LocationProviderTestLanguageLanguage() {
		super("org.eclipse.xtext.resource.LocationProviderTestLanguage");
		this.injector = new org.eclipse.xtext.resource.idea.LocationProviderTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
