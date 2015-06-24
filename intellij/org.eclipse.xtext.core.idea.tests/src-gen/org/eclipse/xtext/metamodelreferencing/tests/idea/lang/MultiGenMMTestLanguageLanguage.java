package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class MultiGenMMTestLanguageLanguage extends AbstractXtextLanguage {

	public static final MultiGenMMTestLanguageLanguage INSTANCE = new MultiGenMMTestLanguageLanguage();

	private MultiGenMMTestLanguageLanguage() {
		super("org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguage");
	}

}
