package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractBug292245TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug292245TestLanguageFileType extends AbstractBug292245TestLanguageFileType {
  public final static Bug292245TestLanguageFileType INSTANCE = new Bug292245TestLanguageFileType();
  
  public Bug292245TestLanguageFileType() {
    super(Bug292245TestLanguageLanguage.INSTANCE);
  }
}
