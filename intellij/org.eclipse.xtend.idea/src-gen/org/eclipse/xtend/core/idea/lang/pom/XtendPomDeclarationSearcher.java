package org.eclipse.xtend.core.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

public class XtendPomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public XtendPomDeclarationSearcher() {
		super(XtendLanguage.INSTANCE);
	}

}
