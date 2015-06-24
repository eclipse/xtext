package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class ReferenceGrammarTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ReferenceGrammarTestLanguageLanguage INSTANCE = new ReferenceGrammarTestLanguageLanguage();

	private ReferenceGrammarTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage");
	}

}
