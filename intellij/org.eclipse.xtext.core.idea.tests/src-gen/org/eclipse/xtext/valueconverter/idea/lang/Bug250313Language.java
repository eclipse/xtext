package org.eclipse.xtext.valueconverter.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug250313Language extends AbstractXtextLanguage {

	public static final Bug250313Language INSTANCE = new Bug250313Language();

	private Injector injector;

	private Bug250313Language() {
		super("org.eclipse.xtext.valueconverter.Bug250313");
		this.injector = new org.eclipse.xtext.valueconverter.idea.Bug250313StandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
