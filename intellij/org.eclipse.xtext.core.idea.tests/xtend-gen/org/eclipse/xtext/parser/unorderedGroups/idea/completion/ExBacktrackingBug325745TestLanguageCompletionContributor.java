package org.eclipse.xtext.parser.unorderedGroups.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.completion.AbstractExBacktrackingBug325745TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage;

@SuppressWarnings("all")
public class ExBacktrackingBug325745TestLanguageCompletionContributor extends AbstractExBacktrackingBug325745TestLanguageCompletionContributor {
  public ExBacktrackingBug325745TestLanguageCompletionContributor() {
    this(ExBacktrackingBug325745TestLanguageLanguage.INSTANCE);
  }
  
  public ExBacktrackingBug325745TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
