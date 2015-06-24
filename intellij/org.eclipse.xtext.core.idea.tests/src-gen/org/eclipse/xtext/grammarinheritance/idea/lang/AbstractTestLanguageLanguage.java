package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class AbstractTestLanguageLanguage extends AbstractXtextLanguage {

	public static final AbstractTestLanguageLanguage INSTANCE = new AbstractTestLanguageLanguage();

	private AbstractTestLanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.AbstractTestLanguage");
	}

}
