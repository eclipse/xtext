package org.eclipse.xtext.xbase.annotations.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class XbaseWithAnnotationsLanguage extends AbstractXtextLanguage {

	public static final XbaseWithAnnotationsLanguage INSTANCE = new XbaseWithAnnotationsLanguage();

	private Injector injector;

	private XbaseWithAnnotationsLanguage() {
		super("org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations");
		this.injector = new org.eclipse.xtext.xbase.annotations.idea.XbaseWithAnnotationsStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
