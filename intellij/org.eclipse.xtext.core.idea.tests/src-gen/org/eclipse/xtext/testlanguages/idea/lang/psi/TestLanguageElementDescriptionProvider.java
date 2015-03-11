package org.eclipse.xtext.testlanguages.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

public class TestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public TestLanguageElementDescriptionProvider() {
		super(TestLanguageLanguage.INSTANCE);
	}

}
