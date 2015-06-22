package org.eclipse.xtext.enumrules.idea.lang;

import org.eclipse.xtext.enumrules.idea.lang.AbstractEnumAndReferenceTestLanguageFileType;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;

@SuppressWarnings("all")
public class EnumAndReferenceTestLanguageFileType extends AbstractEnumAndReferenceTestLanguageFileType {
  public final static EnumAndReferenceTestLanguageFileType INSTANCE = new EnumAndReferenceTestLanguageFileType();
  
  public EnumAndReferenceTestLanguageFileType() {
    super(EnumAndReferenceTestLanguageLanguage.INSTANCE);
  }
}
