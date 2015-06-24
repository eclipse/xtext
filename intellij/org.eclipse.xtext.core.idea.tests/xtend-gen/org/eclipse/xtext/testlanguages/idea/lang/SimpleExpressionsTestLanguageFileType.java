package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractSimpleExpressionsTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleExpressionsTestLanguageFileType extends AbstractSimpleExpressionsTestLanguageFileType {
  public final static SimpleExpressionsTestLanguageFileType INSTANCE = new SimpleExpressionsTestLanguageFileType();
  
  public SimpleExpressionsTestLanguageFileType() {
    super(SimpleExpressionsTestLanguageLanguage.INSTANCE);
  }
}
