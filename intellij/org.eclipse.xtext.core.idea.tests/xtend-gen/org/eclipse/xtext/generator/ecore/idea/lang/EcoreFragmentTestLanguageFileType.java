package org.eclipse.xtext.generator.ecore.idea.lang;

import org.eclipse.xtext.generator.ecore.idea.lang.AbstractEcoreFragmentTestLanguageFileType;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage;

@SuppressWarnings("all")
public class EcoreFragmentTestLanguageFileType extends AbstractEcoreFragmentTestLanguageFileType {
  public final static EcoreFragmentTestLanguageFileType INSTANCE = new EcoreFragmentTestLanguageFileType();
  
  public EcoreFragmentTestLanguageFileType() {
    super(EcoreFragmentTestLanguageLanguage.INSTANCE);
  }
}
