package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class SyntacticSequencerTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SyntacticSequencerTestLanguageLanguage INSTANCE = new SyntacticSequencerTestLanguageLanguage();

	private Injector injector;

	private SyntacticSequencerTestLanguageLanguage() {
		super("org.eclipse.xtext.serializer.SyntacticSequencerTestLanguage");
		this.injector = new org.eclipse.xtext.serializer.idea.SyntacticSequencerTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
