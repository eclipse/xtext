package org.eclipse.xtext.valueconverter.idea.lang;

import org.eclipse.xtext.valueconverter.idea.lang.AbstractQualifiedNameTestLanguageFileType;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage;

@SuppressWarnings("all")
public class QualifiedNameTestLanguageFileType extends AbstractQualifiedNameTestLanguageFileType {
  public final static QualifiedNameTestLanguageFileType INSTANCE = new QualifiedNameTestLanguageFileType();
  
  public QualifiedNameTestLanguageFileType() {
    super(QualifiedNameTestLanguageLanguage.INSTANCE);
  }
}
