package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractHiddenTokensMergerTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;

@SuppressWarnings("all")
public class HiddenTokensMergerTestLanguageCompletionContributor extends AbstractHiddenTokensMergerTestLanguageCompletionContributor {
  public HiddenTokensMergerTestLanguageCompletionContributor() {
    this(HiddenTokensMergerTestLanguageLanguage.INSTANCE);
  }
  
  public HiddenTokensMergerTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
