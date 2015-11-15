package org.eclipse.xtext.generator.ecore.idea.completion;

import org.eclipse.xtext.generator.ecore.idea.completion.AbstractSuperTestLanguageCompletionContributor;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class SuperTestLanguageCompletionContributor extends AbstractSuperTestLanguageCompletionContributor {
  public SuperTestLanguageCompletionContributor() {
    this(SuperTestLanguageLanguage.INSTANCE);
  }
  
  public SuperTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
