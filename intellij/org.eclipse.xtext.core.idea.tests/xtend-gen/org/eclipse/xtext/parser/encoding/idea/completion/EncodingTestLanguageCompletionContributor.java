package org.eclipse.xtext.parser.encoding.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.encoding.idea.completion.AbstractEncodingTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;

@SuppressWarnings("all")
public class EncodingTestLanguageCompletionContributor extends AbstractEncodingTestLanguageCompletionContributor {
  public EncodingTestLanguageCompletionContributor() {
    this(EncodingTestLanguageLanguage.INSTANCE);
  }
  
  public EncodingTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
