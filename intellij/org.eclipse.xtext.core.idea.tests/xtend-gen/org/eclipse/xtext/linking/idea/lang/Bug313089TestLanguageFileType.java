package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractBug313089TestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;

@SuppressWarnings("all")
public class Bug313089TestLanguageFileType extends AbstractBug313089TestLanguageFileType {
  public final static Bug313089TestLanguageFileType INSTANCE = new Bug313089TestLanguageFileType();
  
  public Bug313089TestLanguageFileType() {
    super(Bug313089TestLanguageLanguage.INSTANCE);
  }
}
