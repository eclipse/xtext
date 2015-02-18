package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractComplexReconstrTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;

@SuppressWarnings("all")
public class ComplexReconstrTestLanguageCompletionContributor extends AbstractComplexReconstrTestLanguageCompletionContributor {
  public ComplexReconstrTestLanguageCompletionContributor() {
    this(ComplexReconstrTestLanguageLanguage.INSTANCE);
  }
  
  public ComplexReconstrTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
