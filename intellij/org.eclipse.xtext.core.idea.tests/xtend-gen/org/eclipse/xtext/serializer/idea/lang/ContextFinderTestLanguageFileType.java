package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.serializer.idea.lang.AbstractContextFinderTestLanguageFileType;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage;

@SuppressWarnings("all")
public class ContextFinderTestLanguageFileType extends AbstractContextFinderTestLanguageFileType {
  public final static ContextFinderTestLanguageFileType INSTANCE = new ContextFinderTestLanguageFileType();
  
  public ContextFinderTestLanguageFileType() {
    super(ContextFinderTestLanguageLanguage.INSTANCE);
  }
}
