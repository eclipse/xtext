package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractTerminalRulesTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage;

@SuppressWarnings("all")
public class TerminalRulesTestLanguageFileType extends AbstractTerminalRulesTestLanguageFileType {
  public final static TerminalRulesTestLanguageFileType INSTANCE = new TerminalRulesTestLanguageFileType();
  
  public TerminalRulesTestLanguageFileType() {
    super(TerminalRulesTestLanguageLanguage.INSTANCE);
  }
}
