package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractBug287988TestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug287988TestLanguageFileType extends AbstractBug287988TestLanguageFileType {
  public final static Bug287988TestLanguageFileType INSTANCE = new Bug287988TestLanguageFileType();
  
  public Bug287988TestLanguageFileType() {
    super(Bug287988TestLanguageLanguage.INSTANCE);
  }
}
