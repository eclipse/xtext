package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.AbstractEcoreReferenceTestLanguageFileType;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

@SuppressWarnings("all")
public class EcoreReferenceTestLanguageFileType extends AbstractEcoreReferenceTestLanguageFileType {
  public final static EcoreReferenceTestLanguageFileType INSTANCE = new EcoreReferenceTestLanguageFileType();
  
  public EcoreReferenceTestLanguageFileType() {
    super(EcoreReferenceTestLanguageLanguage.INSTANCE);
  }
}
