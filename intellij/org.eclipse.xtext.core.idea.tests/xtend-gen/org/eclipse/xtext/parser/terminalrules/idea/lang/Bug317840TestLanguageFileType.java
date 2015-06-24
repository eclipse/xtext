package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractBug317840TestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug317840TestLanguageFileType extends AbstractBug317840TestLanguageFileType {
  public final static Bug317840TestLanguageFileType INSTANCE = new Bug317840TestLanguageFileType();
  
  public Bug317840TestLanguageFileType() {
    super(Bug317840TestLanguageLanguage.INSTANCE);
  }
}
