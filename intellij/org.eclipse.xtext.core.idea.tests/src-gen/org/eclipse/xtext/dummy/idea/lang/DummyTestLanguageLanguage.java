package org.eclipse.xtext.dummy.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class DummyTestLanguageLanguage extends AbstractXtextLanguage {

	public static final DummyTestLanguageLanguage INSTANCE = new DummyTestLanguageLanguage();

	private DummyTestLanguageLanguage() {
		super("org.eclipse.xtext.dummy.DummyTestLanguage");
	}

}
