package org.eclipse.xtext.idea.common.types.idea.lang;

import org.eclipse.xtext.idea.common.types.idea.lang.AbstractRefactoringTestLanguageFileType;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

@SuppressWarnings("all")
public class RefactoringTestLanguageFileType extends AbstractRefactoringTestLanguageFileType {
  public final static RefactoringTestLanguageFileType INSTANCE = new RefactoringTestLanguageFileType();
  
  public RefactoringTestLanguageFileType() {
    super(RefactoringTestLanguageLanguage.INSTANCE);
  }
}
