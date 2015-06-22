package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractLangATestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;

@SuppressWarnings("all")
public class LangATestLanguageFileType extends AbstractLangATestLanguageFileType {
  public final static LangATestLanguageFileType INSTANCE = new LangATestLanguageFileType();
  
  public LangATestLanguageFileType() {
    super(LangATestLanguageLanguage.INSTANCE);
  }
}
