package org.eclipse.xtext.linking.lazy.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.lazy.idea.completion.AbstractLazyLinkingTestLanguageCompletionContributor;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

@SuppressWarnings("all")
public class LazyLinkingTestLanguageCompletionContributor extends AbstractLazyLinkingTestLanguageCompletionContributor {
  public LazyLinkingTestLanguageCompletionContributor() {
    this(LazyLinkingTestLanguageLanguage.INSTANCE);
  }
  
  public LazyLinkingTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
