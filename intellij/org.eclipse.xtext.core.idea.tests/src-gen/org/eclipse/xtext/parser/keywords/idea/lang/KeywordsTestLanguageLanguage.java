package org.eclipse.xtext.parser.keywords.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class KeywordsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final KeywordsTestLanguageLanguage INSTANCE = new KeywordsTestLanguageLanguage();

	private KeywordsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.keywords.KeywordsTestLanguage");
	}

}
