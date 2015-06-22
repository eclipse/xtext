package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug378967TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug378967TestLanguageFileType extends AbstractBug378967TestLanguageFileType {
  public final static Bug378967TestLanguageFileType INSTANCE = new Bug378967TestLanguageFileType();
  
  public Bug378967TestLanguageFileType() {
    super(Bug378967TestLanguageLanguage.INSTANCE);
  }
}
