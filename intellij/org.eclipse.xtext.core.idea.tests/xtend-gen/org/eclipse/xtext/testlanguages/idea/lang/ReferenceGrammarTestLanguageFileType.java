package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractReferenceGrammarTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;

@SuppressWarnings("all")
public class ReferenceGrammarTestLanguageFileType extends AbstractReferenceGrammarTestLanguageFileType {
  public final static ReferenceGrammarTestLanguageFileType INSTANCE = new ReferenceGrammarTestLanguageFileType();
  
  public ReferenceGrammarTestLanguageFileType() {
    super(ReferenceGrammarTestLanguageLanguage.INSTANCE);
  }
}
