package org.eclipse.xtext.resource.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.completion.AbstractEObjectAtOffsetTestLanguageCompletionContributor;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;

@SuppressWarnings("all")
public class EObjectAtOffsetTestLanguageCompletionContributor extends AbstractEObjectAtOffsetTestLanguageCompletionContributor {
  public EObjectAtOffsetTestLanguageCompletionContributor() {
    this(EObjectAtOffsetTestLanguageLanguage.INSTANCE);
  }
  
  public EObjectAtOffsetTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
