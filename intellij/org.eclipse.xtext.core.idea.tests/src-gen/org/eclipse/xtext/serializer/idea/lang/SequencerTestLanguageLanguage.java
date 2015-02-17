package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SequencerTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SequencerTestLanguageLanguage INSTANCE = new SequencerTestLanguageLanguage();

	private Injector injector;

	private SequencerTestLanguageLanguage() {
		super("org.eclipse.xtext.serializer.SequencerTestLanguage");
		this.injector = new org.eclipse.xtext.serializer.idea.SequencerTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
