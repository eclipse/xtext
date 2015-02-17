package org.eclipse.xtext.parsetree.impl.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class Bug305397Language extends AbstractXtextLanguage {

	public static final Bug305397Language INSTANCE = new Bug305397Language();

	private Injector injector;

	private Bug305397Language() {
		super("org.eclipse.xtext.parsetree.impl.Bug305397");
		this.injector = new org.eclipse.xtext.parsetree.impl.idea.Bug305397StandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
