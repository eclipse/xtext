package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractFowlerDslTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

@SuppressWarnings("all")
public class FowlerDslTestLanguageFileType extends AbstractFowlerDslTestLanguageFileType {
  public final static FowlerDslTestLanguageFileType INSTANCE = new FowlerDslTestLanguageFileType();
  
  public FowlerDslTestLanguageFileType() {
    super(FowlerDslTestLanguageLanguage.INSTANCE);
  }
}
