package org.eclipse.xtext.grammarinheritance.idea.completion;

import org.eclipse.xtext.grammarinheritance.idea.completion.AbstractInheritanceTest3LanguageCompletionContributor;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class InheritanceTest3LanguageCompletionContributor extends AbstractInheritanceTest3LanguageCompletionContributor {
  public InheritanceTest3LanguageCompletionContributor() {
    this(InheritanceTest3LanguageLanguage.INSTANCE);
  }
  
  public InheritanceTest3LanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
