package org.eclipse.xtext.parsetree.formatter.idea.lang;

import org.eclipse.xtext.parsetree.formatter.idea.lang.AbstractElementMatcherTestLanguageFileType;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;

@SuppressWarnings("all")
public class ElementMatcherTestLanguageFileType extends AbstractElementMatcherTestLanguageFileType {
  public final static ElementMatcherTestLanguageFileType INSTANCE = new ElementMatcherTestLanguageFileType();
  
  public ElementMatcherTestLanguageFileType() {
    super(ElementMatcherTestLanguageLanguage.INSTANCE);
  }
}
