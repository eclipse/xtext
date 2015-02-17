package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class HiddenTokenSequencerTestLanguageLanguage extends AbstractXtextLanguage {

	public static final HiddenTokenSequencerTestLanguageLanguage INSTANCE = new HiddenTokenSequencerTestLanguageLanguage();

	private Injector injector;

	private HiddenTokenSequencerTestLanguageLanguage() {
		super("org.eclipse.xtext.serializer.HiddenTokenSequencerTestLanguage");
		this.injector = new org.eclipse.xtext.serializer.idea.HiddenTokenSequencerTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
