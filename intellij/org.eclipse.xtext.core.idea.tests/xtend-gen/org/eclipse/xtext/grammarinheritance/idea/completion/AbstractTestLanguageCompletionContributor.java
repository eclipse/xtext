package org.eclipse.xtext.grammarinheritance.idea.completion;

import org.eclipse.xtext.grammarinheritance.idea.completion.AbstractAbstractTestLanguageCompletionContributor;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class AbstractTestLanguageCompletionContributor extends AbstractAbstractTestLanguageCompletionContributor {
  public AbstractTestLanguageCompletionContributor() {
    this(AbstractTestLanguageLanguage.INSTANCE);
  }
  
  public AbstractTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
