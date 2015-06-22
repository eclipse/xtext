package org.eclipse.xtext.generator.grammarAccess.idea.lang;

import org.eclipse.xtext.generator.grammarAccess.idea.lang.AbstractGrammarAccessTestLanguageFileType;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;

@SuppressWarnings("all")
public class GrammarAccessTestLanguageFileType extends AbstractGrammarAccessTestLanguageFileType {
  public final static GrammarAccessTestLanguageFileType INSTANCE = new GrammarAccessTestLanguageFileType();
  
  public GrammarAccessTestLanguageFileType() {
    super(GrammarAccessTestLanguageLanguage.INSTANCE);
  }
}
