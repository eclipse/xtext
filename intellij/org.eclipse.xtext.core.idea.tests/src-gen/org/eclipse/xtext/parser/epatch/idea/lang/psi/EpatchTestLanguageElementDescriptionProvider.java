package org.eclipse.xtext.parser.epatch.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

public class EpatchTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public EpatchTestLanguageElementDescriptionProvider() {
		super(EpatchTestLanguageLanguage.INSTANCE);
	}

}
