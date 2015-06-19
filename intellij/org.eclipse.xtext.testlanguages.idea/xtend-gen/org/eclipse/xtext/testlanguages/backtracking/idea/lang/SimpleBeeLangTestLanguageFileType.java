package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.AbstractSimpleBeeLangTestLanguageFileType;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleBeeLangTestLanguageFileType extends AbstractSimpleBeeLangTestLanguageFileType {
  public final static SimpleBeeLangTestLanguageFileType INSTANCE = new SimpleBeeLangTestLanguageFileType();
  
  public SimpleBeeLangTestLanguageFileType() {
    super(SimpleBeeLangTestLanguageLanguage.INSTANCE);
  }
}
