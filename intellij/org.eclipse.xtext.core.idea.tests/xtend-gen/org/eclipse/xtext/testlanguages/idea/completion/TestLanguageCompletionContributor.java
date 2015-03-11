package org.eclipse.xtext.testlanguages.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.testlanguages.idea.completion.AbstractTestLanguageCompletionContributor;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

@SuppressWarnings("all")
public class TestLanguageCompletionContributor extends AbstractTestLanguageCompletionContributor {
  public TestLanguageCompletionContributor() {
    this(TestLanguageLanguage.INSTANCE);
  }
  
  public TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
