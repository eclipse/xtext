package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractUnicodeTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;

@SuppressWarnings("all")
public class UnicodeTestLanguageCompletionContributor extends AbstractUnicodeTestLanguageCompletionContributor {
  public UnicodeTestLanguageCompletionContributor() {
    this(UnicodeTestLanguageLanguage.INSTANCE);
  }
  
  public UnicodeTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
