package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

public class EcoreReferenceTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public EcoreReferenceTestLanguageElementDescriptionProvider() {
		super(EcoreReferenceTestLanguageLanguage.INSTANCE);
	}

}
