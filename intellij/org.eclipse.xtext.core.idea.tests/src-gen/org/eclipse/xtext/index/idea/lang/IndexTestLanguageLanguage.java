package org.eclipse.xtext.index.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class IndexTestLanguageLanguage extends AbstractXtextLanguage {

	public static final IndexTestLanguageLanguage INSTANCE = new IndexTestLanguageLanguage();

	private IndexTestLanguageLanguage() {
		super("org.eclipse.xtext.index.IndexTestLanguage");
	}

}
