package org.eclipse.xtext.dummy.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;

public class DummyTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public DummyTestLanguageElementDescriptionProvider() {
		super(DummyTestLanguageLanguage.INSTANCE);
	}

}
