package org.eclipse.xtext.parser.indentation.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;

public class IndentationAwareTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public IndentationAwareTestLanguagePomDeclarationSearcher() {
		super(IndentationAwareTestLanguageLanguage.INSTANCE);
	}

}
