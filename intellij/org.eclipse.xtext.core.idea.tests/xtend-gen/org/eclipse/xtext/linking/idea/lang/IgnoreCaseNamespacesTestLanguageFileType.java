package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseNamespacesTestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage;

@SuppressWarnings("all")
public class IgnoreCaseNamespacesTestLanguageFileType extends AbstractIgnoreCaseNamespacesTestLanguageFileType {
  public final static IgnoreCaseNamespacesTestLanguageFileType INSTANCE = new IgnoreCaseNamespacesTestLanguageFileType();
  
  public IgnoreCaseNamespacesTestLanguageFileType() {
    super(IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE);
  }
}
