package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug301935TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug301935TestLanguageFileType extends AbstractBug301935TestLanguageFileType {
  public final static Bug301935TestLanguageFileType INSTANCE = new Bug301935TestLanguageFileType();
  
  public Bug301935TestLanguageFileType() {
    super(Bug301935TestLanguageLanguage.INSTANCE);
  }
}
