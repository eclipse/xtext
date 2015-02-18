package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractSerializationErrorTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage;

@SuppressWarnings("all")
public class SerializationErrorTestLanguageCompletionContributor extends AbstractSerializationErrorTestLanguageCompletionContributor {
  public SerializationErrorTestLanguageCompletionContributor() {
    this(SerializationErrorTestLanguageLanguage.INSTANCE);
  }
  
  public SerializationErrorTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
