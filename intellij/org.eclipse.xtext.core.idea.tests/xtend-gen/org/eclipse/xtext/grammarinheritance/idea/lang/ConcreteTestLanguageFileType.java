package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractConcreteTestLanguageFileType;
import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage;

@SuppressWarnings("all")
public class ConcreteTestLanguageFileType extends AbstractConcreteTestLanguageFileType {
  public final static ConcreteTestLanguageFileType INSTANCE = new ConcreteTestLanguageFileType();
  
  public ConcreteTestLanguageFileType() {
    super(ConcreteTestLanguageLanguage.INSTANCE);
  }
}
