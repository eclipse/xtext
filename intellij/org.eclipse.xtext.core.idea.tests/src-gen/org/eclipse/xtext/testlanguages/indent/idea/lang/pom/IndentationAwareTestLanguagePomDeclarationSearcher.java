package org.eclipse.xtext.testlanguages.indent.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage;

public class IndentationAwareTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public IndentationAwareTestLanguagePomDeclarationSearcher() {
		super(IndentationAwareTestLanguageLanguage.INSTANCE);
	}

}
