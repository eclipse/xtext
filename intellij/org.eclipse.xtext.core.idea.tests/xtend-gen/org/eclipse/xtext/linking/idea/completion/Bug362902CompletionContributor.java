package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractBug362902CompletionContributor;
import org.eclipse.xtext.linking.idea.lang.Bug362902Language;

@SuppressWarnings("all")
public class Bug362902CompletionContributor extends AbstractBug362902CompletionContributor {
  public Bug362902CompletionContributor() {
    this(Bug362902Language.INSTANCE);
  }
  
  public Bug362902CompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
