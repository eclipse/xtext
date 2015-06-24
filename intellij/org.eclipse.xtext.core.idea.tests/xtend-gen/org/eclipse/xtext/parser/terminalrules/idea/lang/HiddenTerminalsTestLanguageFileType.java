package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractHiddenTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

@SuppressWarnings("all")
public class HiddenTerminalsTestLanguageFileType extends AbstractHiddenTerminalsTestLanguageFileType {
  public final static HiddenTerminalsTestLanguageFileType INSTANCE = new HiddenTerminalsTestLanguageFileType();
  
  public HiddenTerminalsTestLanguageFileType() {
    super(HiddenTerminalsTestLanguageLanguage.INSTANCE);
  }
}
