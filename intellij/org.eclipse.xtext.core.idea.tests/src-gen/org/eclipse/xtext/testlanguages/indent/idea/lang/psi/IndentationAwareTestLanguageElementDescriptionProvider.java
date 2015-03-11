package org.eclipse.xtext.testlanguages.indent.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage;

public class IndentationAwareTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public IndentationAwareTestLanguageElementDescriptionProvider() {
		super(IndentationAwareTestLanguageLanguage.INSTANCE);
	}

}
