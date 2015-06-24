package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug289524ExTestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289524ExTestLanguageFileType extends AbstractBug289524ExTestLanguageFileType {
  public final static Bug289524ExTestLanguageFileType INSTANCE = new Bug289524ExTestLanguageFileType();
  
  public Bug289524ExTestLanguageFileType() {
    super(Bug289524ExTestLanguageLanguage.INSTANCE);
  }
}
