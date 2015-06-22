package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.serializer.idea.lang.AbstractSequencerTestLanguageFileType;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;

@SuppressWarnings("all")
public class SequencerTestLanguageFileType extends AbstractSequencerTestLanguageFileType {
  public final static SequencerTestLanguageFileType INSTANCE = new SequencerTestLanguageFileType();
  
  public SequencerTestLanguageFileType() {
    super(SequencerTestLanguageLanguage.INSTANCE);
  }
}
