package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.resource.idea.lang.AbstractLiveContainerBuilderIntegerationTestLanguageFileType;
import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage;

@SuppressWarnings("all")
public class LiveContainerBuilderIntegerationTestLanguageFileType extends AbstractLiveContainerBuilderIntegerationTestLanguageFileType {
  public final static LiveContainerBuilderIntegerationTestLanguageFileType INSTANCE = new LiveContainerBuilderIntegerationTestLanguageFileType();
  
  public LiveContainerBuilderIntegerationTestLanguageFileType() {
    super(LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE);
  }
}
