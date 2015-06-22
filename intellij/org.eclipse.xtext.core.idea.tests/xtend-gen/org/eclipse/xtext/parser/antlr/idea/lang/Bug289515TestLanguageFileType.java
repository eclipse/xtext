package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug289515TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289515TestLanguageFileType extends AbstractBug289515TestLanguageFileType {
  public final static Bug289515TestLanguageFileType INSTANCE = new Bug289515TestLanguageFileType();
  
  public Bug289515TestLanguageFileType() {
    super(Bug289515TestLanguageLanguage.INSTANCE);
  }
}
