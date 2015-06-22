package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractSimpleReconstrTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleReconstrTestLanguageFileType extends AbstractSimpleReconstrTestLanguageFileType {
  public final static SimpleReconstrTestLanguageFileType INSTANCE = new SimpleReconstrTestLanguageFileType();
  
  public SimpleReconstrTestLanguageFileType() {
    super(SimpleReconstrTestLanguageLanguage.INSTANCE);
  }
}
