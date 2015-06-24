package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractSerializationErrorTestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage;

@SuppressWarnings("all")
public class SerializationErrorTestLanguageFileType extends AbstractSerializationErrorTestLanguageFileType {
  public final static SerializationErrorTestLanguageFileType INSTANCE = new SerializationErrorTestLanguageFileType();
  
  public SerializationErrorTestLanguageFileType() {
    super(SerializationErrorTestLanguageLanguage.INSTANCE);
  }
}
