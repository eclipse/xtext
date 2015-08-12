package org.eclipse.xtext.parser.parameters.idea.lang;

import org.eclipse.xtext.parser.parameters.idea.lang.AbstractNoParametersTestLanguageFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;

@SuppressWarnings("all")
public class NoParametersTestLanguageFileType extends AbstractNoParametersTestLanguageFileType {
  public final static NoParametersTestLanguageFileType INSTANCE = new NoParametersTestLanguageFileType();
  
  public NoParametersTestLanguageFileType() {
    super(NoParametersTestLanguageLanguage.INSTANCE);
  }
}
