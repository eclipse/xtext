package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class EcoreReferenceTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EcoreReferenceTestLanguageLanguage INSTANCE = new EcoreReferenceTestLanguageLanguage();

	private EcoreReferenceTestLanguageLanguage() {
		super("org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguage");
	}

}
