package org.eclipse.xtext.lexer.idea.lang;

import org.eclipse.xtext.lexer.idea.lang.AbstractIgnoreCaseLexerTestLanguageFileType;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;

@SuppressWarnings("all")
public class IgnoreCaseLexerTestLanguageFileType extends AbstractIgnoreCaseLexerTestLanguageFileType {
  public final static IgnoreCaseLexerTestLanguageFileType INSTANCE = new IgnoreCaseLexerTestLanguageFileType();
  
  public IgnoreCaseLexerTestLanguageFileType() {
    super(IgnoreCaseLexerTestLanguageLanguage.INSTANCE);
  }
}
