package org.eclipse.xtext.generator.ecore.idea.completion;

import org.eclipse.xtext.generator.ecore.idea.completion.AbstractEcoreFragmentTestLanguageCompletionContributor;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class EcoreFragmentTestLanguageCompletionContributor extends AbstractEcoreFragmentTestLanguageCompletionContributor {
  public EcoreFragmentTestLanguageCompletionContributor() {
    this(EcoreFragmentTestLanguageLanguage.INSTANCE);
  }
  
  public EcoreFragmentTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
