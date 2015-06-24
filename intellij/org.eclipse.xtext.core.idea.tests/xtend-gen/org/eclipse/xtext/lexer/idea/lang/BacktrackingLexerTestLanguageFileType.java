package org.eclipse.xtext.lexer.idea.lang;

import org.eclipse.xtext.lexer.idea.lang.AbstractBacktrackingLexerTestLanguageFileType;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

@SuppressWarnings("all")
public class BacktrackingLexerTestLanguageFileType extends AbstractBacktrackingLexerTestLanguageFileType {
  public final static BacktrackingLexerTestLanguageFileType INSTANCE = new BacktrackingLexerTestLanguageFileType();
  
  public BacktrackingLexerTestLanguageFileType() {
    super(BacktrackingLexerTestLanguageLanguage.INSTANCE);
  }
}
