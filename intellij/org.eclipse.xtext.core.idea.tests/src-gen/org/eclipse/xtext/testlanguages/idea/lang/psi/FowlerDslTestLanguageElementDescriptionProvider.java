package org.eclipse.xtext.testlanguages.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

public class FowlerDslTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public FowlerDslTestLanguageElementDescriptionProvider() {
		super(FowlerDslTestLanguageLanguage.INSTANCE);
	}

}
