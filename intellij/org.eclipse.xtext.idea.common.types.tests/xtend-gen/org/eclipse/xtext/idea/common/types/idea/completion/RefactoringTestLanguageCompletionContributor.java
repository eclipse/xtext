package org.eclipse.xtext.idea.common.types.idea.completion;

import org.eclipse.xtext.idea.common.types.idea.completion.AbstractRefactoringTestLanguageCompletionContributor;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class RefactoringTestLanguageCompletionContributor extends AbstractRefactoringTestLanguageCompletionContributor {
  public RefactoringTestLanguageCompletionContributor() {
    this(RefactoringTestLanguageLanguage.INSTANCE);
  }
  
  public RefactoringTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
