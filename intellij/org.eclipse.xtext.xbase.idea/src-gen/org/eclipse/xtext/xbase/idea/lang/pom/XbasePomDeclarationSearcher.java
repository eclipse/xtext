package org.eclipse.xtext.xbase.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

public class XbasePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public XbasePomDeclarationSearcher() {
		super(XbaseLanguage.INSTANCE);
	}

}
