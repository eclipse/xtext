package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractPartialParserTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;

@SuppressWarnings("all")
public class PartialParserTestLanguageFileType extends AbstractPartialParserTestLanguageFileType {
  public final static PartialParserTestLanguageFileType INSTANCE = new PartialParserTestLanguageFileType();
  
  public PartialParserTestLanguageFileType() {
    super(PartialParserTestLanguageLanguage.INSTANCE);
  }
}
