package org.eclipse.xtext.linking.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;

public class IgnoreCaseImportsTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public IgnoreCaseImportsTestLanguagePomDeclarationSearcher() {
		super(IgnoreCaseImportsTestLanguageLanguage.INSTANCE);
	}

}
