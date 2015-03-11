package org.eclipse.xtext.grammarinheritance.idea.completion;

import org.eclipse.xtext.grammarinheritance.idea.completion.AbstractBaseInheritanceTestLanguageCompletionContributor;
import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class BaseInheritanceTestLanguageCompletionContributor extends AbstractBaseInheritanceTestLanguageCompletionContributor {
  public BaseInheritanceTestLanguageCompletionContributor() {
    this(BaseInheritanceTestLanguageLanguage.INSTANCE);
  }
  
  public BaseInheritanceTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
