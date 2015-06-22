package org.eclipse.xtext.parser.encoding.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class EncodingTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EncodingTestLanguageLanguage INSTANCE = new EncodingTestLanguageLanguage();

	private EncodingTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.encoding.EncodingTestLanguage");
	}

}
