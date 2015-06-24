package org.eclipse.xtext.generator.grammarAccess.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class GrammarAccessTestLanguageLanguage extends AbstractXtextLanguage {

	public static final GrammarAccessTestLanguageLanguage INSTANCE = new GrammarAccessTestLanguageLanguage();

	private GrammarAccessTestLanguageLanguage() {
		super("org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguage");
	}

}
