package org.eclipse.xtext.idea.example.entities.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

public class EntitiesElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public EntitiesElementDescriptionProvider() {
		super(EntitiesLanguage.INSTANCE);
	}

}
