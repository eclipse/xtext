package org.eclipse.xtext.parser.datatyperules.idea.lang;

import org.eclipse.xtext.parser.datatyperules.idea.lang.AbstractDatatypeRulesTestLanguageFileType;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;

@SuppressWarnings("all")
public class DatatypeRulesTestLanguageFileType extends AbstractDatatypeRulesTestLanguageFileType {
  public final static DatatypeRulesTestLanguageFileType INSTANCE = new DatatypeRulesTestLanguageFileType();
  
  public DatatypeRulesTestLanguageFileType() {
    super(DatatypeRulesTestLanguageLanguage.INSTANCE);
  }
}
