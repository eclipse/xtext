package org.eclipse.xtext.parser.unorderedGroups.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.completion.AbstractBacktrackingBug325745TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage;

@SuppressWarnings("all")
public class BacktrackingBug325745TestLanguageCompletionContributor extends AbstractBacktrackingBug325745TestLanguageCompletionContributor {
  public BacktrackingBug325745TestLanguageCompletionContributor() {
    this(BacktrackingBug325745TestLanguageLanguage.INSTANCE);
  }
  
  public BacktrackingBug325745TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
