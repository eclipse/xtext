package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class SimpleExpressionsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final SimpleExpressionsTestLanguageLanguage INSTANCE = new SimpleExpressionsTestLanguageLanguage();

	private SimpleExpressionsTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage");
	}

}
