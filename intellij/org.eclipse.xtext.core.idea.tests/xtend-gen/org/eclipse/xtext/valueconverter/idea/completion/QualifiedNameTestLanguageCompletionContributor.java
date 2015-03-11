package org.eclipse.xtext.valueconverter.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.valueconverter.idea.completion.AbstractQualifiedNameTestLanguageCompletionContributor;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage;

@SuppressWarnings("all")
public class QualifiedNameTestLanguageCompletionContributor extends AbstractQualifiedNameTestLanguageCompletionContributor {
  public QualifiedNameTestLanguageCompletionContributor() {
    this(QualifiedNameTestLanguageLanguage.INSTANCE);
  }
  
  public QualifiedNameTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
