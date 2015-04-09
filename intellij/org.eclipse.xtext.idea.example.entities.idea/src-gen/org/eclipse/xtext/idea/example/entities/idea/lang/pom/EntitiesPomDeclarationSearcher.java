package org.eclipse.xtext.idea.example.entities.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

public class EntitiesPomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public EntitiesPomDeclarationSearcher() {
		super(EntitiesLanguage.INSTANCE);
	}

}
