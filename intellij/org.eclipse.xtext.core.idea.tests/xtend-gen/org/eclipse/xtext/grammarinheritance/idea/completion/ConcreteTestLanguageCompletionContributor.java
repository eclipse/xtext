package org.eclipse.xtext.grammarinheritance.idea.completion;

import org.eclipse.xtext.grammarinheritance.idea.completion.AbstractConcreteTestLanguageCompletionContributor;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class ConcreteTestLanguageCompletionContributor extends AbstractConcreteTestLanguageCompletionContributor {
  public ConcreteTestLanguageCompletionContributor() {
    this(ConcreteTestLanguageLanguage.INSTANCE);
  }
  
  public ConcreteTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
