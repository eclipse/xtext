package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractSerializationBug269362TestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;

@SuppressWarnings("all")
public class SerializationBug269362TestLanguageCompletionContributor extends AbstractSerializationBug269362TestLanguageCompletionContributor {
  public SerializationBug269362TestLanguageCompletionContributor() {
    this(SerializationBug269362TestLanguageLanguage.INSTANCE);
  }
  
  public SerializationBug269362TestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
