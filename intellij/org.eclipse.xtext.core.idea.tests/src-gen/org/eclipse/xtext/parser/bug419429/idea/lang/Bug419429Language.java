package org.eclipse.xtext.parser.bug419429.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug419429Language extends AbstractXtextLanguage {

	public static final Bug419429Language INSTANCE = new Bug419429Language();

	private Injector injector;

	private Bug419429Language() {
		super("org.eclipse.xtext.parser.bug419429.Bug419429");
		this.injector = new org.eclipse.xtext.parser.bug419429.idea.Bug419429StandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
