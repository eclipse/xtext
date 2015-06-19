package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.AbstractBeeLangTestLanguageFileType;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;

@SuppressWarnings("all")
public class BeeLangTestLanguageFileType extends AbstractBeeLangTestLanguageFileType {
  public final static BeeLangTestLanguageFileType INSTANCE = new BeeLangTestLanguageFileType();
  
  public BeeLangTestLanguageFileType() {
    super(BeeLangTestLanguageLanguage.INSTANCE);
  }
}
