package org.eclipse.xtext.dummy.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;

public class DummyTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public DummyTestLanguagePomDeclarationSearcher() {
		super(DummyTestLanguageLanguage.INSTANCE);
	}

}
