package org.eclipse.xtext.idea.example.entities.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

public class EntitiesSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EntitiesSemanticHighlightVisitor() {
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}
}
