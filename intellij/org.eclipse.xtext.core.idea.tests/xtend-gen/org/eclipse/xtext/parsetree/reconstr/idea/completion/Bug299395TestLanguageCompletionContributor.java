package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractBug299395TestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug299395TestLanguageCompletionContributor extends AbstractBug299395TestLanguageCompletionContributor {
  public Bug299395TestLanguageCompletionContributor() {
    this(Bug299395TestLanguageLanguage.INSTANCE);
  }
  
  public Bug299395TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
