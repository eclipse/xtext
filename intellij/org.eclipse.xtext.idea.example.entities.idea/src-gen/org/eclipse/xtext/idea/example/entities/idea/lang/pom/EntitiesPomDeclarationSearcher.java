package org.eclipse.xtext.idea.example.entities.idea.lang.pom;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;

public class EntitiesPomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public EntitiesPomDeclarationSearcher() {
		super(EntitiesLanguage.INSTANCE);
	}

}
