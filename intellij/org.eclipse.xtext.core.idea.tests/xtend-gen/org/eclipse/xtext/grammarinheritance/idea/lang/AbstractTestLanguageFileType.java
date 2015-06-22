package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractAbstractTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;

@SuppressWarnings("all")
public class AbstractTestLanguageFileType extends AbstractAbstractTestLanguageFileType {
  public final static AbstractTestLanguageFileType INSTANCE = new AbstractTestLanguageFileType();
  
  public AbstractTestLanguageFileType() {
    super(AbstractTestLanguageLanguage.INSTANCE);
  }
}
