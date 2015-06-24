package org.eclipse.xtext.parser.keywords.idea.lang;

import org.eclipse.xtext.parser.keywords.idea.lang.AbstractKeywordsTestLanguageFileType;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;

@SuppressWarnings("all")
public class KeywordsTestLanguageFileType extends AbstractKeywordsTestLanguageFileType {
  public final static KeywordsTestLanguageFileType INSTANCE = new KeywordsTestLanguageFileType();
  
  public KeywordsTestLanguageFileType() {
    super(KeywordsTestLanguageLanguage.INSTANCE);
  }
}
