package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractInheritanceTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;

@SuppressWarnings("all")
public class InheritanceTestLanguageFileType extends AbstractInheritanceTestLanguageFileType {
  public final static InheritanceTestLanguageFileType INSTANCE = new InheritanceTestLanguageFileType();
  
  public InheritanceTestLanguageFileType() {
    super(InheritanceTestLanguageLanguage.INSTANCE);
  }
}
