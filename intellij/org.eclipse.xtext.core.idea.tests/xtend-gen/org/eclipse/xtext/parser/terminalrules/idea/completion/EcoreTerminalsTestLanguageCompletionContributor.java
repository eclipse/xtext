package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractEcoreTerminalsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;

@SuppressWarnings("all")
public class EcoreTerminalsTestLanguageCompletionContributor extends AbstractEcoreTerminalsTestLanguageCompletionContributor {
  public EcoreTerminalsTestLanguageCompletionContributor() {
    this(EcoreTerminalsTestLanguageLanguage.INSTANCE);
  }
  
  public EcoreTerminalsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
