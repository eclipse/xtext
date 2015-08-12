package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractInheritanceTest3LanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;

@SuppressWarnings("all")
public class InheritanceTest3LanguageFileType extends AbstractInheritanceTest3LanguageFileType {
  public final static InheritanceTest3LanguageFileType INSTANCE = new InheritanceTest3LanguageFileType();
  
  public InheritanceTest3LanguageFileType() {
    super(InheritanceTest3LanguageLanguage.INSTANCE);
  }
}
