package org.eclipse.xtext.testlanguages.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

public class TestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public TestLanguagePomDeclarationSearcher() {
		super(TestLanguageLanguage.INSTANCE);
	}

}
