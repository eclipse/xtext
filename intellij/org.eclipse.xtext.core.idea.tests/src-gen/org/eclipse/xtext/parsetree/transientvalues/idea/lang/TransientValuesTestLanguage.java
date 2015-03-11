package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class TransientValuesTestLanguage extends AbstractXtextLanguage {

	public static final TransientValuesTestLanguage INSTANCE = new TransientValuesTestLanguage();

	private Injector injector;

	private TransientValuesTestLanguage() {
		super("org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest");
		this.injector = new org.eclipse.xtext.parsetree.transientvalues.idea.TransientValuesTestStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
