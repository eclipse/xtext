package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class ActionTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ActionTestLanguageLanguage INSTANCE = new ActionTestLanguageLanguage();

	private ActionTestLanguageLanguage() {
		super("org.eclipse.xtext.testlanguages.ActionTestLanguage");
	}

}
