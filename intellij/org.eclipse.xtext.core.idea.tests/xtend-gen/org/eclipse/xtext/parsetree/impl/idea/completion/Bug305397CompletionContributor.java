package org.eclipse.xtext.parsetree.impl.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.impl.idea.completion.AbstractBug305397CompletionContributor;
import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language;

@SuppressWarnings("all")
public class Bug305397CompletionContributor extends AbstractBug305397CompletionContributor {
  public Bug305397CompletionContributor() {
    this(Bug305397Language.INSTANCE);
  }
  
  public Bug305397CompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
