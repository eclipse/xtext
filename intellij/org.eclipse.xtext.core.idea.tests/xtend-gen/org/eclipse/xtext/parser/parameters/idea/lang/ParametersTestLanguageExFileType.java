package org.eclipse.xtext.parser.parameters.idea.lang;

import org.eclipse.xtext.parser.parameters.idea.lang.AbstractParametersTestLanguageExFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage;

@SuppressWarnings("all")
public class ParametersTestLanguageExFileType extends AbstractParametersTestLanguageExFileType {
  public final static ParametersTestLanguageExFileType INSTANCE = new ParametersTestLanguageExFileType();
  
  public ParametersTestLanguageExFileType() {
    super(ParametersTestLanguageExLanguage.INSTANCE);
  }
}
