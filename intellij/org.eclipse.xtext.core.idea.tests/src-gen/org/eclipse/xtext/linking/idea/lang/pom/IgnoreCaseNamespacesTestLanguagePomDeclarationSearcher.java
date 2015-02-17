package org.eclipse.xtext.linking.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage;

public class IgnoreCaseNamespacesTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public IgnoreCaseNamespacesTestLanguagePomDeclarationSearcher() {
		super(IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE);
	}

}
