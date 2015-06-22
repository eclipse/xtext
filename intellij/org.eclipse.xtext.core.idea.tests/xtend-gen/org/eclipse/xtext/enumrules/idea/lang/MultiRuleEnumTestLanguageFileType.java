package org.eclipse.xtext.enumrules.idea.lang;

import org.eclipse.xtext.enumrules.idea.lang.AbstractMultiRuleEnumTestLanguageFileType;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage;

@SuppressWarnings("all")
public class MultiRuleEnumTestLanguageFileType extends AbstractMultiRuleEnumTestLanguageFileType {
  public final static MultiRuleEnumTestLanguageFileType INSTANCE = new MultiRuleEnumTestLanguageFileType();
  
  public MultiRuleEnumTestLanguageFileType() {
    super(MultiRuleEnumTestLanguageLanguage.INSTANCE);
  }
}
