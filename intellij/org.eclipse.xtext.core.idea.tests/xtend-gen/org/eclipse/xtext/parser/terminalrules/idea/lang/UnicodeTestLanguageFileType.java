package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractUnicodeTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;

@SuppressWarnings("all")
public class UnicodeTestLanguageFileType extends AbstractUnicodeTestLanguageFileType {
  public final static UnicodeTestLanguageFileType INSTANCE = new UnicodeTestLanguageFileType();
  
  public UnicodeTestLanguageFileType() {
    super(UnicodeTestLanguageLanguage.INSTANCE);
  }
}
