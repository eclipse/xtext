package org.eclipse.xtend.core.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class XtendLanguage extends AbstractXtextLanguage {

	public static final XtendLanguage INSTANCE = new XtendLanguage();

	private Injector injector;

	private XtendLanguage() {
		super("org.eclipse.xtend.core.Xtend");
		this.injector = new org.eclipse.xtend.core.idea.XtendStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
