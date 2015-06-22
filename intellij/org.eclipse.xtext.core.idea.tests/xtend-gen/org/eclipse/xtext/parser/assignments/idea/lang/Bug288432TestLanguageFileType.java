package org.eclipse.xtext.parser.assignments.idea.lang;

import org.eclipse.xtext.parser.assignments.idea.lang.AbstractBug288432TestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug288432TestLanguageFileType extends AbstractBug288432TestLanguageFileType {
  public final static Bug288432TestLanguageFileType INSTANCE = new Bug288432TestLanguageFileType();
  
  public Bug288432TestLanguageFileType() {
    super(Bug288432TestLanguageLanguage.INSTANCE);
  }
}
