package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import org.eclipse.xtext.xtext.ecoreInference.idea.lang.AbstractMultiValueFeatureTestLanguageFileType;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;

@SuppressWarnings("all")
public class MultiValueFeatureTestLanguageFileType extends AbstractMultiValueFeatureTestLanguageFileType {
  public final static MultiValueFeatureTestLanguageFileType INSTANCE = new MultiValueFeatureTestLanguageFileType();
  
  public MultiValueFeatureTestLanguageFileType() {
    super(MultiValueFeatureTestLanguageLanguage.INSTANCE);
  }
}
