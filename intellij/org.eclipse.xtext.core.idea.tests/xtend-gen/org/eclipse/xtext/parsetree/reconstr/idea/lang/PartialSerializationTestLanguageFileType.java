package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractPartialSerializationTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage;

@SuppressWarnings("all")
public class PartialSerializationTestLanguageFileType extends AbstractPartialSerializationTestLanguageFileType {
  public final static PartialSerializationTestLanguageFileType INSTANCE = new PartialSerializationTestLanguageFileType();
  
  public PartialSerializationTestLanguageFileType() {
    super(PartialSerializationTestLanguageLanguage.INSTANCE);
  }
}
