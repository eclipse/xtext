package org.eclipse.xtext.parser.indentation.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;

public class IndentationAwareTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public IndentationAwareTestLanguageElementDescriptionProvider() {
		super(IndentationAwareTestLanguageLanguage.INSTANCE);
	}

}
