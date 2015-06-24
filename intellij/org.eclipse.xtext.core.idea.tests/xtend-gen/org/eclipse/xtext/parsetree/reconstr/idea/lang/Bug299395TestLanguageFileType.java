package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractBug299395TestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug299395TestLanguageFileType extends AbstractBug299395TestLanguageFileType {
  public final static Bug299395TestLanguageFileType INSTANCE = new Bug299395TestLanguageFileType();
  
  public Bug299395TestLanguageFileType() {
    super(Bug299395TestLanguageLanguage.INSTANCE);
  }
}
