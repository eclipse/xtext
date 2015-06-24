package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.serializer.idea.lang.AbstractSyntacticSequencerTestLanguageFileType;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;

@SuppressWarnings("all")
public class SyntacticSequencerTestLanguageFileType extends AbstractSyntacticSequencerTestLanguageFileType {
  public final static SyntacticSequencerTestLanguageFileType INSTANCE = new SyntacticSequencerTestLanguageFileType();
  
  public SyntacticSequencerTestLanguageFileType() {
    super(SyntacticSequencerTestLanguageLanguage.INSTANCE);
  }
}
