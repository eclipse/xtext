package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractEcoreTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;

@SuppressWarnings("all")
public class EcoreTerminalsTestLanguageFileType extends AbstractEcoreTerminalsTestLanguageFileType {
  public final static EcoreTerminalsTestLanguageFileType INSTANCE = new EcoreTerminalsTestLanguageFileType();
  
  public EcoreTerminalsTestLanguageFileType() {
    super(EcoreTerminalsTestLanguageLanguage.INSTANCE);
  }
}
