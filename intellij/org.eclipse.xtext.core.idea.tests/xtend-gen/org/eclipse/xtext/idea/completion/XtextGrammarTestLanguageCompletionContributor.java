package org.eclipse.xtext.idea.completion;

import org.eclipse.xtext.idea.completion.AbstractXtextGrammarTestLanguageCompletionContributor;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage;

@SuppressWarnings("all")
public class XtextGrammarTestLanguageCompletionContributor extends AbstractXtextGrammarTestLanguageCompletionContributor {
  public XtextGrammarTestLanguageCompletionContributor() {
    this(XtextGrammarTestLanguageLanguage.INSTANCE);
  }
  
  public XtextGrammarTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
