package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class LangATestLanguageLanguage extends AbstractXtextLanguage {

	public static final LangATestLanguageLanguage INSTANCE = new LangATestLanguageLanguage();

	private LangATestLanguageLanguage() {
		super("org.eclipse.xtext.linking.LangATestLanguage");
	}

}
