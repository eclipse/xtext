package org.eclipse.xtext.linking.lazy.idea.lang;

import org.eclipse.xtext.linking.lazy.idea.lang.AbstractBug311337TestLanguageFileType;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug311337TestLanguageFileType extends AbstractBug311337TestLanguageFileType {
  public final static Bug311337TestLanguageFileType INSTANCE = new Bug311337TestLanguageFileType();
  
  public Bug311337TestLanguageFileType() {
    super(Bug311337TestLanguageLanguage.INSTANCE);
  }
}
