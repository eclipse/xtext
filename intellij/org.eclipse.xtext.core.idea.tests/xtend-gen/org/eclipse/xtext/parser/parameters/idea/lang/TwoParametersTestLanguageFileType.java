package org.eclipse.xtext.parser.parameters.idea.lang;

import org.eclipse.xtext.parser.parameters.idea.lang.AbstractTwoParametersTestLanguageFileType;
import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage;

@SuppressWarnings("all")
public class TwoParametersTestLanguageFileType extends AbstractTwoParametersTestLanguageFileType {
  public final static TwoParametersTestLanguageFileType INSTANCE = new TwoParametersTestLanguageFileType();
  
  public TwoParametersTestLanguageFileType() {
    super(TwoParametersTestLanguageLanguage.INSTANCE);
  }
}
