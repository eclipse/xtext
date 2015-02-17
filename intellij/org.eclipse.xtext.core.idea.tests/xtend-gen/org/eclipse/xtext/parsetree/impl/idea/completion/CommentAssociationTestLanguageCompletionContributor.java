package org.eclipse.xtext.parsetree.impl.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.impl.idea.completion.AbstractCommentAssociationTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage;

@SuppressWarnings("all")
public class CommentAssociationTestLanguageCompletionContributor extends AbstractCommentAssociationTestLanguageCompletionContributor {
  public CommentAssociationTestLanguageCompletionContributor() {
    this(CommentAssociationTestLanguageLanguage.INSTANCE);
  }
  
  public CommentAssociationTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
