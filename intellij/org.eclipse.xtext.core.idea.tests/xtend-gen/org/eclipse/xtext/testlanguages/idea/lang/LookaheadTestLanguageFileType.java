package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractLookaheadTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;

@SuppressWarnings("all")
public class LookaheadTestLanguageFileType extends AbstractLookaheadTestLanguageFileType {
  public final static LookaheadTestLanguageFileType INSTANCE = new LookaheadTestLanguageFileType();
  
  public LookaheadTestLanguageFileType() {
    super(LookaheadTestLanguageLanguage.INSTANCE);
  }
}
