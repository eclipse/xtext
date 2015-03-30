package org.eclipse.xtext.idea.example.entities.idea.lang.psi;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;

public class EntitiesElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public EntitiesElementDescriptionProvider() {
		super(EntitiesLanguage.INSTANCE);
	}

}
