package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractInheritanceTest2LanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;

@SuppressWarnings("all")
public class InheritanceTest2LanguageFileType extends AbstractInheritanceTest2LanguageFileType {
  public final static InheritanceTest2LanguageFileType INSTANCE = new InheritanceTest2LanguageFileType();
  
  public InheritanceTest2LanguageFileType() {
    super(InheritanceTest2LanguageLanguage.INSTANCE);
  }
}
