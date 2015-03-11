package org.eclipse.xtext.testlanguages.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

public class TreeTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public TreeTestLanguageElementDescriptionProvider() {
		super(TreeTestLanguageLanguage.INSTANCE);
	}

}
