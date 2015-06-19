package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.AbstractExBeeLangTestLanguageFileType;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage;

@SuppressWarnings("all")
public class ExBeeLangTestLanguageFileType extends AbstractExBeeLangTestLanguageFileType {
  public final static ExBeeLangTestLanguageFileType INSTANCE = new ExBeeLangTestLanguageFileType();
  
  public ExBeeLangTestLanguageFileType() {
    super(ExBeeLangTestLanguageLanguage.INSTANCE);
  }
}
