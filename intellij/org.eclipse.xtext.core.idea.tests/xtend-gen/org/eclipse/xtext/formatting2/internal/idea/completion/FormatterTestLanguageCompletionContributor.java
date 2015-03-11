package org.eclipse.xtext.formatting2.internal.idea.completion;

import org.eclipse.xtext.formatting2.internal.idea.completion.AbstractFormatterTestLanguageCompletionContributor;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class FormatterTestLanguageCompletionContributor extends AbstractFormatterTestLanguageCompletionContributor {
  public FormatterTestLanguageCompletionContributor() {
    this(FormatterTestLanguageLanguage.INSTANCE);
  }
  
  public FormatterTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
