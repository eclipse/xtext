package org.eclipse.xtext.parser.epatch.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class EpatchTestLanguageLanguage extends AbstractXtextLanguage {

	public static final EpatchTestLanguageLanguage INSTANCE = new EpatchTestLanguageLanguage();

	private EpatchTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.epatch.EpatchTestLanguage");
	}

}
