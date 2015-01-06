package org.eclipse.xtext.common.idea.completion;

import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public abstract class TerminalsCompletionContributor extends AbstractCompletionContributor {
  public TerminalsCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
