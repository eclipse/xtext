package org.eclipse.xtext.testlanguages.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;

public class LookaheadTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public LookaheadTestLanguagePomDeclarationSearcher() {
		super(LookaheadTestLanguageLanguage.INSTANCE);
	}

}
