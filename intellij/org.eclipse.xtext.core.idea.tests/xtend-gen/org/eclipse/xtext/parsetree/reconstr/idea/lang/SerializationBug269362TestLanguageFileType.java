package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.AbstractSerializationBug269362TestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;

@SuppressWarnings("all")
public class SerializationBug269362TestLanguageFileType extends AbstractSerializationBug269362TestLanguageFileType {
  public final static SerializationBug269362TestLanguageFileType INSTANCE = new SerializationBug269362TestLanguageFileType();
  
  public SerializationBug269362TestLanguageFileType() {
    super(SerializationBug269362TestLanguageLanguage.INSTANCE);
  }
}
