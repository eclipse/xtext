package org.eclipse.xtext.parser.fragments.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class FragmentTestLanguageLanguage extends AbstractXtextLanguage {

	public static final FragmentTestLanguageLanguage INSTANCE = new FragmentTestLanguageLanguage();

	private FragmentTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.fragments.FragmentTestLanguage");
	}

}
