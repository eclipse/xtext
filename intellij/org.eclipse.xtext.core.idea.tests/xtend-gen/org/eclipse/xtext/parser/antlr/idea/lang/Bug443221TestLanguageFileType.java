package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug443221TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug443221TestLanguageFileType extends AbstractBug443221TestLanguageFileType {
  public final static Bug443221TestLanguageFileType INSTANCE = new Bug443221TestLanguageFileType();
  
  public Bug443221TestLanguageFileType() {
    super(Bug443221TestLanguageLanguage.INSTANCE);
  }
}
