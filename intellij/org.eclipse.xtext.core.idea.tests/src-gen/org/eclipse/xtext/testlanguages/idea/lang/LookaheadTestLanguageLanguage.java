package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class LookaheadTestLanguageLanguage extends AbstractXtextLanguage {

	public static final LookaheadTestLanguageLanguage INSTANCE = new LookaheadTestLanguageLanguage();

	private LookaheadTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.LookaheadTestLanguage");
	}

}
