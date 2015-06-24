package org.eclipse.xtext.validation.idea.lang;

import org.eclipse.xtext.validation.idea.lang.AbstractConcreteSyntaxValidationTestLanguageFileType;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage;

@SuppressWarnings("all")
public class ConcreteSyntaxValidationTestLanguageFileType extends AbstractConcreteSyntaxValidationTestLanguageFileType {
  public final static ConcreteSyntaxValidationTestLanguageFileType INSTANCE = new ConcreteSyntaxValidationTestLanguageFileType();
  
  public ConcreteSyntaxValidationTestLanguageFileType() {
    super(ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE);
  }
}
