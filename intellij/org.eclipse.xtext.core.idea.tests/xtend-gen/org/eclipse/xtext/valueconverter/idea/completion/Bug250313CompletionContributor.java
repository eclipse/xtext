package org.eclipse.xtext.valueconverter.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.valueconverter.idea.completion.AbstractBug250313CompletionContributor;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;

@SuppressWarnings("all")
public class Bug250313CompletionContributor extends AbstractBug250313CompletionContributor {
  public Bug250313CompletionContributor() {
    this(Bug250313Language.INSTANCE);
  }
  
  public Bug250313CompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
