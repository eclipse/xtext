package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractBug289059TestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug289059TestLanguageFileType extends AbstractBug289059TestLanguageFileType {
  public final static Bug289059TestLanguageFileType INSTANCE = new Bug289059TestLanguageFileType();
  
  public Bug289059TestLanguageFileType() {
    super(Bug289059TestLanguageLanguage.INSTANCE);
  }
}
