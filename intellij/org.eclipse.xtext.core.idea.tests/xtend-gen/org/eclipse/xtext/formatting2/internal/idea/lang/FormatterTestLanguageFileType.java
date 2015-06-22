package org.eclipse.xtext.formatting2.internal.idea.lang;

import org.eclipse.xtext.formatting2.internal.idea.lang.AbstractFormatterTestLanguageFileType;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage;

@SuppressWarnings("all")
public class FormatterTestLanguageFileType extends AbstractFormatterTestLanguageFileType {
  public final static FormatterTestLanguageFileType INSTANCE = new FormatterTestLanguageFileType();
  
  public FormatterTestLanguageFileType() {
    super(FormatterTestLanguageLanguage.INSTANCE);
  }
}
