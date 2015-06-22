package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug296889ExTestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage;

@SuppressWarnings("all")
public class Bug296889ExTestLanguageFileType extends AbstractBug296889ExTestLanguageFileType {
  public final static Bug296889ExTestLanguageFileType INSTANCE = new Bug296889ExTestLanguageFileType();
  
  public Bug296889ExTestLanguageFileType() {
    super(Bug296889ExTestLanguageLanguage.INSTANCE);
  }
}
