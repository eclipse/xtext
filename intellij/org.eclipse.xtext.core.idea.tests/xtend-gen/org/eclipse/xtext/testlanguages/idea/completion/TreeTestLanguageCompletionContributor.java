package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractTreeTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

@SuppressWarnings("all")
public class TreeTestLanguageCompletionContributor extends AbstractTreeTestLanguageCompletionContributor {
  public TreeTestLanguageCompletionContributor() {
    this(TreeTestLanguageLanguage.INSTANCE);
  }
  
  public TreeTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
