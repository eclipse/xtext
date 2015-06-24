package org.eclipse.xtext.enumrules.idea.lang;

import org.eclipse.xtext.enumrules.idea.lang.AbstractEnumRulesTestLanguageFileType;
import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage;

@SuppressWarnings("all")
public class EnumRulesTestLanguageFileType extends AbstractEnumRulesTestLanguageFileType {
  public final static EnumRulesTestLanguageFileType INSTANCE = new EnumRulesTestLanguageFileType();
  
  public EnumRulesTestLanguageFileType() {
    super(EnumRulesTestLanguageLanguage.INSTANCE);
  }
}
