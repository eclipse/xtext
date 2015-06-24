package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import org.eclipse.xtext.xtext.ecoreInference.idea.lang.AbstractUnassignedRuleCallTestLanguageFileType;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;

@SuppressWarnings("all")
public class UnassignedRuleCallTestLanguageFileType extends AbstractUnassignedRuleCallTestLanguageFileType {
  public final static UnassignedRuleCallTestLanguageFileType INSTANCE = new UnassignedRuleCallTestLanguageFileType();
  
  public UnassignedRuleCallTestLanguageFileType() {
    super(UnassignedRuleCallTestLanguageLanguage.INSTANCE);
  }
}
