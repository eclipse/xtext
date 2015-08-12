package org.eclipse.xtext.parser.parameters.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class NoParametersTestLanguageLanguage extends AbstractXtextLanguage {

	public static final NoParametersTestLanguageLanguage INSTANCE = new NoParametersTestLanguageLanguage();

	private NoParametersTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.parameters.NoParametersTestLanguage");
	}

}
