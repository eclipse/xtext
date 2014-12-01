package org.eclipse.xtext.idea.common.types.completion;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;

@SuppressWarnings("all")
public class RefactoringTestLanguageCompletionContributor extends AbstractCompletionContributor {
  public RefactoringTestLanguageCompletionContributor() {
    super(RefactoringTestLanguageLanguage.INSTANCE);
  }
}
