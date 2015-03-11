package org.eclipse.xtext.metamodelreferencing.tests.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.idea.completion.AbstractMultiGenMMTestLanguageCompletionContributor;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;

@SuppressWarnings("all")
public class MultiGenMMTestLanguageCompletionContributor extends AbstractMultiGenMMTestLanguageCompletionContributor {
  public MultiGenMMTestLanguageCompletionContributor() {
    this(MultiGenMMTestLanguageLanguage.INSTANCE);
  }
  
  public MultiGenMMTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
