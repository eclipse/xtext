package org.eclipse.xtext.grammarinheritance.idea.completion;

import org.eclipse.xtext.grammarinheritance.idea.completion.AbstractInheritanceTest2LanguageCompletionContributor;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class InheritanceTest2LanguageCompletionContributor extends AbstractInheritanceTest2LanguageCompletionContributor {
  public InheritanceTest2LanguageCompletionContributor() {
    this(InheritanceTest2LanguageLanguage.INSTANCE);
  }
  
  public InheritanceTest2LanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
