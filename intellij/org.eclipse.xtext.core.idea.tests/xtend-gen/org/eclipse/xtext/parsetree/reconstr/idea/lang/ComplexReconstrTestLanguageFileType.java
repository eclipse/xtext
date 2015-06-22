package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractComplexReconstrTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;

@SuppressWarnings("all")
public class ComplexReconstrTestLanguageFileType extends AbstractComplexReconstrTestLanguageFileType {
  public final static ComplexReconstrTestLanguageFileType INSTANCE = new ComplexReconstrTestLanguageFileType();
  
  public ComplexReconstrTestLanguageFileType() {
    super(ComplexReconstrTestLanguageLanguage.INSTANCE);
  }
}
