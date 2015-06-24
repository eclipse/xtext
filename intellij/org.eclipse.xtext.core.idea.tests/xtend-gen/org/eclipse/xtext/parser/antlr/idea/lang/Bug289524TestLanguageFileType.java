package org.eclipse.xtext.parser.antlr.idea.lang;

import org.eclipse.xtext.parser.antlr.idea.lang.AbstractBug289524TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289524TestLanguageFileType extends AbstractBug289524TestLanguageFileType {
  public final static Bug289524TestLanguageFileType INSTANCE = new Bug289524TestLanguageFileType();
  
  public Bug289524TestLanguageFileType() {
    super(Bug289524TestLanguageLanguage.INSTANCE);
  }
}
