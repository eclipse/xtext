package org.eclipse.xtext.parser.encoding.idea.lang;

import org.eclipse.xtext.parser.encoding.idea.lang.AbstractEncodingTestLanguageFileType;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;

@SuppressWarnings("all")
public class EncodingTestLanguageFileType extends AbstractEncodingTestLanguageFileType {
  public final static EncodingTestLanguageFileType INSTANCE = new EncodingTestLanguageFileType();
  
  public EncodingTestLanguageFileType() {
    super(EncodingTestLanguageLanguage.INSTANCE);
  }
}
