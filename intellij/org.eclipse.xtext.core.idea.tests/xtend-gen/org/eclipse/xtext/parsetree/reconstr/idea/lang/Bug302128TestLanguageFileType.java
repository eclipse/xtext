package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractBug302128TestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug302128TestLanguageFileType extends AbstractBug302128TestLanguageFileType {
  public final static Bug302128TestLanguageFileType INSTANCE = new Bug302128TestLanguageFileType();
  
  public Bug302128TestLanguageFileType() {
    super(Bug302128TestLanguageLanguage.INSTANCE);
  }
}
