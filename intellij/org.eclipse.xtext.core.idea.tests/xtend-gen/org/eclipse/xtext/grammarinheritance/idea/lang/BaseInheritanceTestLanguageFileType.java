package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractBaseInheritanceTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage;

@SuppressWarnings("all")
public class BaseInheritanceTestLanguageFileType extends AbstractBaseInheritanceTestLanguageFileType {
  public final static BaseInheritanceTestLanguageFileType INSTANCE = new BaseInheritanceTestLanguageFileType();
  
  public BaseInheritanceTestLanguageFileType() {
    super(BaseInheritanceTestLanguageLanguage.INSTANCE);
  }
}
