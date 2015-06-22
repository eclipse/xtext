package org.eclipse.xtext.parser.epatch.idea.lang;

import org.eclipse.xtext.parser.epatch.idea.lang.AbstractEpatchTestLanguageFileType;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

@SuppressWarnings("all")
public class EpatchTestLanguageFileType extends AbstractEpatchTestLanguageFileType {
  public final static EpatchTestLanguageFileType INSTANCE = new EpatchTestLanguageFileType();
  
  public EpatchTestLanguageFileType() {
    super(EpatchTestLanguageLanguage.INSTANCE);
  }
}
