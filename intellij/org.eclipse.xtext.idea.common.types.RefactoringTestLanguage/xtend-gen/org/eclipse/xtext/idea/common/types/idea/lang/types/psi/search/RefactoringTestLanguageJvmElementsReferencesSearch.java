package org.eclipse.xtext.idea.common.types.idea.lang.types.psi.search;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch;

@SuppressWarnings("all")
public class RefactoringTestLanguageJvmElementsReferencesSearch extends JvmElementsReferencesSearch {
  public RefactoringTestLanguageJvmElementsReferencesSearch() {
    super(RefactoringTestLanguageLanguage.INSTANCE);
  }
}
