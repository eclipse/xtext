package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.resource.idea.lang.AbstractLiveContainerTestLanguageFileType;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;

@SuppressWarnings("all")
public class LiveContainerTestLanguageFileType extends AbstractLiveContainerTestLanguageFileType {
  public final static LiveContainerTestLanguageFileType INSTANCE = new LiveContainerTestLanguageFileType();
  
  public LiveContainerTestLanguageFileType() {
    super(LiveContainerTestLanguageLanguage.INSTANCE);
  }
}
