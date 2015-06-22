package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseImportsTestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;

@SuppressWarnings("all")
public class IgnoreCaseImportsTestLanguageFileType extends AbstractIgnoreCaseImportsTestLanguageFileType {
  public final static IgnoreCaseImportsTestLanguageFileType INSTANCE = new IgnoreCaseImportsTestLanguageFileType();
  
  public IgnoreCaseImportsTestLanguageFileType() {
    super(IgnoreCaseImportsTestLanguageLanguage.INSTANCE);
  }
}
