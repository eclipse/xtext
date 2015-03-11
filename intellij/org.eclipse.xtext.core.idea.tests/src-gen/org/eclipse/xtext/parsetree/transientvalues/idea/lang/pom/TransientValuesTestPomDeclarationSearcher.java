package org.eclipse.xtext.parsetree.transientvalues.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

public class TransientValuesTestPomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public TransientValuesTestPomDeclarationSearcher() {
		super(TransientValuesTestLanguage.INSTANCE);
	}

}
