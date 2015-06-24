package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug301935ExTestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;

@SuppressWarnings("all")
public class Bug301935ExTestLanguageFileType extends AbstractBug301935ExTestLanguageFileType {
  public final static Bug301935ExTestLanguageFileType INSTANCE = new Bug301935ExTestLanguageFileType();
  
  public Bug301935ExTestLanguageFileType() {
    super(Bug301935ExTestLanguageLanguage.INSTANCE);
  }
}
