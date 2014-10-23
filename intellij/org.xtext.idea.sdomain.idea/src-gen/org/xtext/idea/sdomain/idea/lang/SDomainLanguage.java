package org.xtext.idea.sdomain.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SDomainLanguage extends AbstractXtextLanguage {

	public static final SDomainLanguage INSTANCE = new SDomainLanguage();

	private Injector injector;

	private SDomainLanguage() {
		super("org.xtext.idea.sdomain.SDomain");
		this.injector = new org.xtext.idea.sdomain.idea.SDomainStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
