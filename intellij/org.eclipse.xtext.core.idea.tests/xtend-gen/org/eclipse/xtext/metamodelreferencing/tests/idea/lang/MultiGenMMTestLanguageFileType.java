package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.AbstractMultiGenMMTestLanguageFileType;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;

@SuppressWarnings("all")
public class MultiGenMMTestLanguageFileType extends AbstractMultiGenMMTestLanguageFileType {
  public final static MultiGenMMTestLanguageFileType INSTANCE = new MultiGenMMTestLanguageFileType();
  
  public MultiGenMMTestLanguageFileType() {
    super(MultiGenMMTestLanguageLanguage.INSTANCE);
  }
}
