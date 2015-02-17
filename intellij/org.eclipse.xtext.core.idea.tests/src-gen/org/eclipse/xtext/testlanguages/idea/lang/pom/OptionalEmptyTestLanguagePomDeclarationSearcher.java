package org.eclipse.xtext.testlanguages.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

public class OptionalEmptyTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public OptionalEmptyTestLanguagePomDeclarationSearcher() {
		super(OptionalEmptyTestLanguageLanguage.INSTANCE);
	}

}
