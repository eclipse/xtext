package org.eclipse.xtext.parsetree.formatter.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.formatter.idea.completion.AbstractFormatterTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageLanguage;

@SuppressWarnings("all")
public class FormatterTestLanguageCompletionContributor extends AbstractFormatterTestLanguageCompletionContributor {
  public FormatterTestLanguageCompletionContributor() {
    this(FormatterTestLanguageLanguage.INSTANCE);
  }
  
  public FormatterTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
