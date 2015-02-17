package org.eclipse.xtext.parser.assignments.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.assignments.idea.completion.AbstractBug287184TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug287184TestLanguageCompletionContributor extends AbstractBug287184TestLanguageCompletionContributor {
  public Bug287184TestLanguageCompletionContributor() {
    this(Bug287184TestLanguageLanguage.INSTANCE);
  }
  
  public Bug287184TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
