package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class TreeTestLanguageLanguage extends AbstractXtextLanguage {

	public static final TreeTestLanguageLanguage INSTANCE = new TreeTestLanguageLanguage();

	private TreeTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.TreeTestLanguage");
	}

}
