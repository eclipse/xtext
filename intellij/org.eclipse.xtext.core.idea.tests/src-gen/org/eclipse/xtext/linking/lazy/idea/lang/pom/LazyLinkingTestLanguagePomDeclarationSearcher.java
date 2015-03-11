package org.eclipse.xtext.linking.lazy.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

public class LazyLinkingTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public LazyLinkingTestLanguagePomDeclarationSearcher() {
		super(LazyLinkingTestLanguageLanguage.INSTANCE);
	}

}
