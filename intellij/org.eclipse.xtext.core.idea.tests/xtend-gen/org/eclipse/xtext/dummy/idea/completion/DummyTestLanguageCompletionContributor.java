package org.eclipse.xtext.dummy.idea.completion;

import org.eclipse.xtext.dummy.idea.completion.AbstractDummyTestLanguageCompletionContributor;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class DummyTestLanguageCompletionContributor extends AbstractDummyTestLanguageCompletionContributor {
  public DummyTestLanguageCompletionContributor() {
    this(DummyTestLanguageLanguage.INSTANCE);
  }
  
  public DummyTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
