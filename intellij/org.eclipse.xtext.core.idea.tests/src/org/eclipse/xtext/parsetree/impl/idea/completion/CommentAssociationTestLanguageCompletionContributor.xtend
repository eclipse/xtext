package org.eclipse.xtext.parsetree.impl.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage;

class CommentAssociationTestLanguageCompletionContributor extends AbstractCommentAssociationTestLanguageCompletionContributor {
	new() {
		this(CommentAssociationTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


