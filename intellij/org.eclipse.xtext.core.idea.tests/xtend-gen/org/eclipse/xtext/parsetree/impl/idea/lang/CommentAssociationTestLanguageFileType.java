package org.eclipse.xtext.parsetree.impl.idea.lang;

import org.eclipse.xtext.parsetree.impl.idea.lang.AbstractCommentAssociationTestLanguageFileType;
import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage;

@SuppressWarnings("all")
public class CommentAssociationTestLanguageFileType extends AbstractCommentAssociationTestLanguageFileType {
  public final static CommentAssociationTestLanguageFileType INSTANCE = new CommentAssociationTestLanguageFileType();
  
  public CommentAssociationTestLanguageFileType() {
    super(CommentAssociationTestLanguageLanguage.INSTANCE);
  }
}
