package org.eclipse.xtext.testlanguages.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

public class FowlerDslTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public FowlerDslTestLanguagePomDeclarationSearcher() {
		super(FowlerDslTestLanguageLanguage.INSTANCE);
	}

}
