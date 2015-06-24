package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class InheritanceTestLanguageLanguage extends AbstractXtextLanguage {

	public static final InheritanceTestLanguageLanguage INSTANCE = new InheritanceTestLanguageLanguage();

	private InheritanceTestLanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.InheritanceTestLanguage");
	}

}
