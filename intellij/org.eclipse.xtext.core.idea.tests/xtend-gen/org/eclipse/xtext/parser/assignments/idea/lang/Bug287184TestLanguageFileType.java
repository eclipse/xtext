package org.eclipse.xtext.parser.assignments.idea.lang;

import org.eclipse.xtext.parser.assignments.idea.lang.AbstractBug287184TestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug287184TestLanguageFileType extends AbstractBug287184TestLanguageFileType {
  public final static Bug287184TestLanguageFileType INSTANCE = new Bug287184TestLanguageFileType();
  
  public Bug287184TestLanguageFileType() {
    super(Bug287184TestLanguageLanguage.INSTANCE);
  }
}
