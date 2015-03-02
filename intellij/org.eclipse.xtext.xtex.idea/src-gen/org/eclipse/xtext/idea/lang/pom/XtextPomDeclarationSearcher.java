package org.eclipse.xtext.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.idea.lang.XtextLanguage;

public class XtextPomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public XtextPomDeclarationSearcher() {
		super(XtextLanguage.INSTANCE);
	}

}
