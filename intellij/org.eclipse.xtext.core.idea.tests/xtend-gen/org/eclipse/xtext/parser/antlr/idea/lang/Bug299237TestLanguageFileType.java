package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug299237TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug299237TestLanguageFileType extends AbstractBug299237TestLanguageFileType {
  public final static Bug299237TestLanguageFileType INSTANCE = new Bug299237TestLanguageFileType();
  
  public Bug299237TestLanguageFileType() {
    super(Bug299237TestLanguageLanguage.INSTANCE);
  }
}
