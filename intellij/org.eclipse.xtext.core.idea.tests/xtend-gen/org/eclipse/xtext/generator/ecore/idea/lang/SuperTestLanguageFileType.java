package org.eclipse.xtext.generator.ecore.idea.lang;

import org.eclipse.xtext.generator.ecore.idea.lang.AbstractSuperTestLanguageFileType;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;

@SuppressWarnings("all")
public class SuperTestLanguageFileType extends AbstractSuperTestLanguageFileType {
  public final static SuperTestLanguageFileType INSTANCE = new SuperTestLanguageFileType();
  
  public SuperTestLanguageFileType() {
    super(SuperTestLanguageLanguage.INSTANCE);
  }
}
