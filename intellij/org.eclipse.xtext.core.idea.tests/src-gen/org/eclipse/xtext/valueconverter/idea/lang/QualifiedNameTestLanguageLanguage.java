package org.eclipse.xtext.valueconverter.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class QualifiedNameTestLanguageLanguage extends AbstractXtextLanguage {

	public static final QualifiedNameTestLanguageLanguage INSTANCE = new QualifiedNameTestLanguageLanguage();

	private QualifiedNameTestLanguageLanguage() {
		super("org.eclipse.xtext.valueconverter.QualifiedNameTestLanguage");
	}

}
