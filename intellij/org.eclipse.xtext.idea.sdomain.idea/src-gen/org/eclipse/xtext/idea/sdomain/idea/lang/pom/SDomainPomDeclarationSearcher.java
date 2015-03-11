package org.eclipse.xtext.idea.sdomain.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

public class SDomainPomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public SDomainPomDeclarationSearcher() {
		super(SDomainLanguage.INSTANCE);
	}

}
