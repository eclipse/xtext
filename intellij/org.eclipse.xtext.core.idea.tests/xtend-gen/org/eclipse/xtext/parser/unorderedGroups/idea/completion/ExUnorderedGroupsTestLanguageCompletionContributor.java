package org.eclipse.xtext.parser.unorderedGroups.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.completion.AbstractExUnorderedGroupsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;

@SuppressWarnings("all")
public class ExUnorderedGroupsTestLanguageCompletionContributor extends AbstractExUnorderedGroupsTestLanguageCompletionContributor {
  public ExUnorderedGroupsTestLanguageCompletionContributor() {
    this(ExUnorderedGroupsTestLanguageLanguage.INSTANCE);
  }
  
  public ExUnorderedGroupsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
