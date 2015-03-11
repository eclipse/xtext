package org.eclipse.xtext.testlanguages.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

public class OptionalEmptyTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public OptionalEmptyTestLanguageElementDescriptionProvider() {
		super(OptionalEmptyTestLanguageLanguage.INSTANCE);
	}

}
