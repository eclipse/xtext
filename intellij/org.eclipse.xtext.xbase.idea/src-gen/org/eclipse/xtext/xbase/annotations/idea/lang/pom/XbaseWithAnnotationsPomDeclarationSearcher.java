package org.eclipse.xtext.xbase.annotations.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

public class XbaseWithAnnotationsPomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public XbaseWithAnnotationsPomDeclarationSearcher() {
		super(XbaseWithAnnotationsLanguage.INSTANCE);
	}

}
