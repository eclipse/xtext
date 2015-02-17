package org.eclipse.xtext.testlanguages.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;

public class PartialParserTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public PartialParserTestLanguagePomDeclarationSearcher() {
		super(PartialParserTestLanguageLanguage.INSTANCE);
	}

}
