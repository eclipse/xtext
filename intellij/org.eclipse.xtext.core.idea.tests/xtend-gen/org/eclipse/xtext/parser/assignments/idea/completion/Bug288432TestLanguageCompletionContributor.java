package org.eclipse.xtext.parser.assignments.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.assignments.idea.completion.AbstractBug288432TestLanguageCompletionContributor;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug288432TestLanguageCompletionContributor extends AbstractBug288432TestLanguageCompletionContributor {
  public Bug288432TestLanguageCompletionContributor() {
    this(Bug288432TestLanguageLanguage.INSTANCE);
  }
  
  public Bug288432TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
