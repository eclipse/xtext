package org.eclipse.xtext.parsetree.formatter.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class FormatterTestLanguageLanguage extends AbstractXtextLanguage {

	public static final FormatterTestLanguageLanguage INSTANCE = new FormatterTestLanguageLanguage();

	private FormatterTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage");
	}

}
