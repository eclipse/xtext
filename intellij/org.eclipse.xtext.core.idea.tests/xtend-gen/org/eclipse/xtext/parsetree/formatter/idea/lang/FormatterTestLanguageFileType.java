package org.eclipse.xtext.parsetree.formatter.idea.lang;

import org.eclipse.xtext.parsetree.formatter.idea.lang.AbstractFormatterTestLanguageFileType;
import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageLanguage;

@SuppressWarnings("all")
public class FormatterTestLanguageFileType extends AbstractFormatterTestLanguageFileType {
  public final static FormatterTestLanguageFileType INSTANCE = new FormatterTestLanguageFileType();
  
  public FormatterTestLanguageFileType() {
    super(FormatterTestLanguageLanguage.INSTANCE);
  }
}
