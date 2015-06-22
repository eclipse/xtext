package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractHiddenTokensMergerTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;

@SuppressWarnings("all")
public class HiddenTokensMergerTestLanguageFileType extends AbstractHiddenTokensMergerTestLanguageFileType {
  public final static HiddenTokensMergerTestLanguageFileType INSTANCE = new HiddenTokensMergerTestLanguageFileType();
  
  public HiddenTokensMergerTestLanguageFileType() {
    super(HiddenTokensMergerTestLanguageLanguage.INSTANCE);
  }
}
