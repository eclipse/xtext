package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractBug297105TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug297105TestLanguageFileType extends AbstractBug297105TestLanguageFileType {
  public final static Bug297105TestLanguageFileType INSTANCE = new Bug297105TestLanguageFileType();
  
  public Bug297105TestLanguageFileType() {
    super(Bug297105TestLanguageLanguage.INSTANCE);
  }
}
