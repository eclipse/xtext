package org.eclipse.xtext.parser.unorderedGroups.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.completion.AbstractSimpleBacktrackingBug325745TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleBacktrackingBug325745TestLanguageCompletionContributor extends AbstractSimpleBacktrackingBug325745TestLanguageCompletionContributor {
  public SimpleBacktrackingBug325745TestLanguageCompletionContributor() {
    this(SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE);
  }
  
  public SimpleBacktrackingBug325745TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
