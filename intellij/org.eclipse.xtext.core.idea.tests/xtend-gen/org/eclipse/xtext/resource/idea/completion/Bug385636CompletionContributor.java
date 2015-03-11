package org.eclipse.xtext.resource.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.completion.AbstractBug385636CompletionContributor;
import org.eclipse.xtext.resource.idea.lang.Bug385636Language;

@SuppressWarnings("all")
public class Bug385636CompletionContributor extends AbstractBug385636CompletionContributor {
  public Bug385636CompletionContributor() {
    this(Bug385636Language.INSTANCE);
  }
  
  public Bug385636CompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
