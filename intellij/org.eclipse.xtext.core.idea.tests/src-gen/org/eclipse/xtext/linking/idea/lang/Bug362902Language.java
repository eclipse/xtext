package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug362902Language extends AbstractXtextLanguage {

	public static final Bug362902Language INSTANCE = new Bug362902Language();

	private Injector injector;

	private Bug362902Language() {
		super("org.eclipse.xtext.linking.Bug362902");
		this.injector = new org.eclipse.xtext.linking.idea.Bug362902StandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
