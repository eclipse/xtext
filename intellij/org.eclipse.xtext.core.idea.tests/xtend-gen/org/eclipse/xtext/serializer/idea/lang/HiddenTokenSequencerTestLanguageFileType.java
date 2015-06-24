package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.serializer.idea.lang.AbstractHiddenTokenSequencerTestLanguageFileType;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage;

@SuppressWarnings("all")
public class HiddenTokenSequencerTestLanguageFileType extends AbstractHiddenTokenSequencerTestLanguageFileType {
  public final static HiddenTokenSequencerTestLanguageFileType INSTANCE = new HiddenTokenSequencerTestLanguageFileType();
  
  public HiddenTokenSequencerTestLanguageFileType() {
    super(HiddenTokenSequencerTestLanguageLanguage.INSTANCE);
  }
}
