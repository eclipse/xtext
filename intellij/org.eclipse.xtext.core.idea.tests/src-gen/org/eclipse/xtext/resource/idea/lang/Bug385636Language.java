package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug385636Language extends AbstractXtextLanguage {

	public static final Bug385636Language INSTANCE = new Bug385636Language();

	private Injector injector;

	private Bug385636Language() {
		super("org.eclipse.xtext.resource.Bug385636");
		this.injector = new org.eclipse.xtext.resource.idea.Bug385636StandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
