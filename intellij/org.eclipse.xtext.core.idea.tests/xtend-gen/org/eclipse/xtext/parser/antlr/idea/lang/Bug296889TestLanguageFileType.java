package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug296889TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug296889TestLanguageFileType extends AbstractBug296889TestLanguageFileType {
  public final static Bug296889TestLanguageFileType INSTANCE = new Bug296889TestLanguageFileType();
  
  public Bug296889TestLanguageFileType() {
    super(Bug296889TestLanguageLanguage.INSTANCE);
  }
}
