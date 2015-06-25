package org.eclipse.xtext.purexbase.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

public class PureXbasePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public PureXbasePomDeclarationSearcher() {
		super(PureXbaseLanguage.INSTANCE);
	}

}
