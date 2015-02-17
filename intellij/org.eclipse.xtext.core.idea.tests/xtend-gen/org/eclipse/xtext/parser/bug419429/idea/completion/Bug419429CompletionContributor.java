package org.eclipse.xtext.parser.bug419429.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.bug419429.idea.completion.AbstractBug419429CompletionContributor;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;

@SuppressWarnings("all")
public class Bug419429CompletionContributor extends AbstractBug419429CompletionContributor {
  public Bug419429CompletionContributor() {
    this(Bug419429Language.INSTANCE);
  }
  
  public Bug419429CompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
