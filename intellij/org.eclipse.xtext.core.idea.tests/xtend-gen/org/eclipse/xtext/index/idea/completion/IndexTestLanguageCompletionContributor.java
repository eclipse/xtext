package org.eclipse.xtext.index.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.index.idea.completion.AbstractIndexTestLanguageCompletionContributor;
import org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage;

@SuppressWarnings("all")
public class IndexTestLanguageCompletionContributor extends AbstractIndexTestLanguageCompletionContributor {
  public IndexTestLanguageCompletionContributor() {
    this(IndexTestLanguageLanguage.INSTANCE);
  }
  
  public IndexTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
