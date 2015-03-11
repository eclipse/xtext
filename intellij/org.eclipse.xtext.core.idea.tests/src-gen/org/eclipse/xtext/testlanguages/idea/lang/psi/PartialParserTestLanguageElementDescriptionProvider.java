package org.eclipse.xtext.testlanguages.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;

public class PartialParserTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public PartialParserTestLanguageElementDescriptionProvider() {
		super(PartialParserTestLanguageLanguage.INSTANCE);
	}

}
