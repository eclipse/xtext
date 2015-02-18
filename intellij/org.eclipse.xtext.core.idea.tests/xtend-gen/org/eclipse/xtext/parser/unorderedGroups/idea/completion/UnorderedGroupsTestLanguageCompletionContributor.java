package org.eclipse.xtext.parser.unorderedGroups.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.completion.AbstractUnorderedGroupsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage;

@SuppressWarnings("all")
public class UnorderedGroupsTestLanguageCompletionContributor extends AbstractUnorderedGroupsTestLanguageCompletionContributor {
  public UnorderedGroupsTestLanguageCompletionContributor() {
    this(UnorderedGroupsTestLanguageLanguage.INSTANCE);
  }
  
  public UnorderedGroupsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
