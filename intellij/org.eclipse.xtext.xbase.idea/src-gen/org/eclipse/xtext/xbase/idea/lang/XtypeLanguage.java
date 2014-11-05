package org.eclipse.xtext.xbase.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class XtypeLanguage extends AbstractXtextLanguage {

	public static final XtypeLanguage INSTANCE = new XtypeLanguage();

	private Injector injector;

	private XtypeLanguage() {
		super("org.eclipse.xtext.xbase.Xtype");
		this.injector = new org.eclipse.xtext.xbase.idea.XtypeStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
