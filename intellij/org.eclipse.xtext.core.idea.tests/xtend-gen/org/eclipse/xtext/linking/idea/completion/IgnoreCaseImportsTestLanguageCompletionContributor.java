package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractIgnoreCaseImportsTestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;

@SuppressWarnings("all")
public class IgnoreCaseImportsTestLanguageCompletionContributor extends AbstractIgnoreCaseImportsTestLanguageCompletionContributor {
  public IgnoreCaseImportsTestLanguageCompletionContributor() {
    this(IgnoreCaseImportsTestLanguageLanguage.INSTANCE);
  }
  
  public IgnoreCaseImportsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
