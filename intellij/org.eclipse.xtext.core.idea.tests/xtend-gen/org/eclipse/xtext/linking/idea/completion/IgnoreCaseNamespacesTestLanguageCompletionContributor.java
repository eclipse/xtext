package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractIgnoreCaseNamespacesTestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage;

@SuppressWarnings("all")
public class IgnoreCaseNamespacesTestLanguageCompletionContributor extends AbstractIgnoreCaseNamespacesTestLanguageCompletionContributor {
  public IgnoreCaseNamespacesTestLanguageCompletionContributor() {
    this(IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE);
  }
  
  public IgnoreCaseNamespacesTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
