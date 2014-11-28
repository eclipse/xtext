package org.eclipse.xtext.xbase.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

public class XtypePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public XtypePomDeclarationSearcher() {
		super(XtypeLanguage.INSTANCE);
	}

}
