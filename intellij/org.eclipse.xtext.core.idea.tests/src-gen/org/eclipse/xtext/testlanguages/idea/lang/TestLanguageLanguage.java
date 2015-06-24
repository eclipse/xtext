package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class TestLanguageLanguage extends AbstractXtextLanguage {

	public static final TestLanguageLanguage INSTANCE = new TestLanguageLanguage();

	private TestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.TestLanguage");
	}

}
