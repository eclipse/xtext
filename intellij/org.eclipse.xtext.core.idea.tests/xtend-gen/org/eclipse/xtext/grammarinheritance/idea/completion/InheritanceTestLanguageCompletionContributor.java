package org.eclipse.xtext.grammarinheritance.idea.completion;

import org.eclipse.xtext.grammarinheritance.idea.completion.AbstractInheritanceTestLanguageCompletionContributor;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class InheritanceTestLanguageCompletionContributor extends AbstractInheritanceTestLanguageCompletionContributor {
  public InheritanceTestLanguageCompletionContributor() {
    this(InheritanceTestLanguageLanguage.INSTANCE);
  }
  
  public InheritanceTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
