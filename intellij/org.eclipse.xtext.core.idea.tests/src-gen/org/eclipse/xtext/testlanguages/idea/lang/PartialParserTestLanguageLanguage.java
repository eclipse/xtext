package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class PartialParserTestLanguageLanguage extends AbstractXtextLanguage {

	public static final PartialParserTestLanguageLanguage INSTANCE = new PartialParserTestLanguageLanguage();

	private PartialParserTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.PartialParserTestLanguage");
	}

}
