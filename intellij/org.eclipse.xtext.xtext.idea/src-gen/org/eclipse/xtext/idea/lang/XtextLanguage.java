package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class XtextLanguage extends AbstractXtextLanguage {

	public static final XtextLanguage INSTANCE = new XtextLanguage();

	private Injector injector;

	private XtextLanguage() {
		super("org.eclipse.xtext.Xtext");
		this.injector = new org.eclipse.xtext.idea.XtextStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
