package org.eclipse.xtext.parser.parameters.idea.lang;

import org.eclipse.xtext.parser.parameters.idea.lang.AbstractParametersTestLanguageFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;

@SuppressWarnings("all")
public class ParametersTestLanguageFileType extends AbstractParametersTestLanguageFileType {
  public final static ParametersTestLanguageFileType INSTANCE = new ParametersTestLanguageFileType();
  
  public ParametersTestLanguageFileType() {
    super(ParametersTestLanguageLanguage.INSTANCE);
  }
}
