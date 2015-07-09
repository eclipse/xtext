package org.eclipse.xtext.parsetree.impl.idea.highlighting;

import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage;

public class CommentAssociationTestLanguageSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public CommentAssociationTestLanguageSemanticHighlightVisitor() {
		CommentAssociationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}
}
