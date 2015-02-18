package org.eclipse.xtext.parser.unorderedGroups.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.unorderedGroups.idea.completion.AbstractSimpleUnorderedGroupsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleUnorderedGroupsTestLanguageCompletionContributor extends AbstractSimpleUnorderedGroupsTestLanguageCompletionContributor {
  public SimpleUnorderedGroupsTestLanguageCompletionContributor() {
    this(SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE);
  }
  
  public SimpleUnorderedGroupsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
