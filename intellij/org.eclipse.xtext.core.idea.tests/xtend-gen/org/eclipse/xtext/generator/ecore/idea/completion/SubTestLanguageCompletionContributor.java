package org.eclipse.xtext.generator.ecore.idea.completion;

import org.eclipse.xtext.generator.ecore.idea.completion.AbstractSubTestLanguageCompletionContributor;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class SubTestLanguageCompletionContributor extends AbstractSubTestLanguageCompletionContributor {
  public SubTestLanguageCompletionContributor() {
    this(SubTestLanguageLanguage.INSTANCE);
  }
  
  public SubTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
