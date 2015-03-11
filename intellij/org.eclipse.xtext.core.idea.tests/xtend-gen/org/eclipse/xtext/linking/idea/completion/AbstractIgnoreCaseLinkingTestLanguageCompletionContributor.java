package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractAbstractIgnoreCaseLinkingTestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;

@SuppressWarnings("all")
public class AbstractIgnoreCaseLinkingTestLanguageCompletionContributor extends AbstractAbstractIgnoreCaseLinkingTestLanguageCompletionContributor {
  public AbstractIgnoreCaseLinkingTestLanguageCompletionContributor() {
    this(AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE);
  }
  
  public AbstractIgnoreCaseLinkingTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
