package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractOptionalEmptyTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

@SuppressWarnings("all")
public class OptionalEmptyTestLanguageFileType extends AbstractOptionalEmptyTestLanguageFileType {
  public final static OptionalEmptyTestLanguageFileType INSTANCE = new OptionalEmptyTestLanguageFileType();
  
  public OptionalEmptyTestLanguageFileType() {
    super(OptionalEmptyTestLanguageLanguage.INSTANCE);
  }
}
