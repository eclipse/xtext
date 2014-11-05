package org.eclipse.xtext.xbase.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class XbaseLanguage extends AbstractXtextLanguage {

	public static final XbaseLanguage INSTANCE = new XbaseLanguage();

	private Injector injector;

	private XbaseLanguage() {
		super("org.eclipse.xtext.xbase.Xbase");
		this.injector = new org.eclipse.xtext.xbase.idea.XbaseStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
