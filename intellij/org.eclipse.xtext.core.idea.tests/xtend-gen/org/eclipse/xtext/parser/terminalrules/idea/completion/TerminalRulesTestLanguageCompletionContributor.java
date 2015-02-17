package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractTerminalRulesTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage;

@SuppressWarnings("all")
public class TerminalRulesTestLanguageCompletionContributor extends AbstractTerminalRulesTestLanguageCompletionContributor {
  public TerminalRulesTestLanguageCompletionContributor() {
    this(TerminalRulesTestLanguageLanguage.INSTANCE);
  }
  
  public TerminalRulesTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
