package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class FowlerDslTestLanguageLanguage extends AbstractXtextLanguage {

	public static final FowlerDslTestLanguageLanguage INSTANCE = new FowlerDslTestLanguageLanguage();

	private FowlerDslTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.FowlerDslTestLanguage");
	}

}
