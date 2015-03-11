package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

public class EcoreReferenceTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public EcoreReferenceTestLanguagePomDeclarationSearcher() {
		super(EcoreReferenceTestLanguageLanguage.INSTANCE);
	}

}
