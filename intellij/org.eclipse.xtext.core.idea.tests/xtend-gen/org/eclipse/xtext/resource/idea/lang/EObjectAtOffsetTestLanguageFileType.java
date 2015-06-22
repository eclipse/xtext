package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.resource.idea.lang.AbstractEObjectAtOffsetTestLanguageFileType;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;

@SuppressWarnings("all")
public class EObjectAtOffsetTestLanguageFileType extends AbstractEObjectAtOffsetTestLanguageFileType {
  public final static EObjectAtOffsetTestLanguageFileType INSTANCE = new EObjectAtOffsetTestLanguageFileType();
  
  public EObjectAtOffsetTestLanguageFileType() {
    super(EObjectAtOffsetTestLanguageLanguage.INSTANCE);
  }
}
