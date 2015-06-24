package org.eclipse.xtext.parser.indentation.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class IndentationAwareTestLanguageLanguage extends AbstractXtextLanguage {

	public static final IndentationAwareTestLanguageLanguage INSTANCE = new IndentationAwareTestLanguageLanguage();

	private IndentationAwareTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage");
	}

}
