package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractAbstractIgnoreCaseLinkingTestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;

@SuppressWarnings("all")
public class AbstractIgnoreCaseLinkingTestLanguageFileType extends AbstractAbstractIgnoreCaseLinkingTestLanguageFileType {
  public final static AbstractIgnoreCaseLinkingTestLanguageFileType INSTANCE = new AbstractIgnoreCaseLinkingTestLanguageFileType();
  
  public AbstractIgnoreCaseLinkingTestLanguageFileType() {
    super(AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE);
  }
}
