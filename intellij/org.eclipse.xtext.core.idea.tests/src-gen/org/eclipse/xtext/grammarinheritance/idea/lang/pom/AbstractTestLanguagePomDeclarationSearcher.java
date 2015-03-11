package org.eclipse.xtext.grammarinheritance.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;

public class AbstractTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public AbstractTestLanguagePomDeclarationSearcher() {
		super(AbstractTestLanguageLanguage.INSTANCE);
	}

}
