package org.eclipse.xtext.parsetree.unassignedtext.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.unassignedtext.idea.completion.AbstractUnassignedTextTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;

@SuppressWarnings("all")
public class UnassignedTextTestLanguageCompletionContributor extends AbstractUnassignedTextTestLanguageCompletionContributor {
  public UnassignedTextTestLanguageCompletionContributor() {
    this(UnassignedTextTestLanguageLanguage.INSTANCE);
  }
  
  public UnassignedTextTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
