package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractSimpleReconstrTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleReconstrTestLanguageCompletionContributor extends AbstractSimpleReconstrTestLanguageCompletionContributor {
  public SimpleReconstrTestLanguageCompletionContributor() {
    this(SimpleReconstrTestLanguageLanguage.INSTANCE);
  }
  
  public SimpleReconstrTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
