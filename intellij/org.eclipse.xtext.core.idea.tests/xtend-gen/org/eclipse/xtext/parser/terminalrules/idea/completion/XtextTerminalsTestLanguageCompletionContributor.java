package org.eclipse.xtext.parser.terminalrules.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.terminalrules.idea.completion.AbstractXtextTerminalsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;

@SuppressWarnings("all")
public class XtextTerminalsTestLanguageCompletionContributor extends AbstractXtextTerminalsTestLanguageCompletionContributor {
  public XtextTerminalsTestLanguageCompletionContributor() {
    this(XtextTerminalsTestLanguageLanguage.INSTANCE);
  }
  
  public XtextTerminalsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
