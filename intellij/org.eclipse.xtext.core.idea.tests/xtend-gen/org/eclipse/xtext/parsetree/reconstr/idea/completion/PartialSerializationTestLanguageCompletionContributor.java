package org.eclipse.xtext.parsetree.reconstr.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.reconstr.idea.completion.AbstractPartialSerializationTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage;

@SuppressWarnings("all")
public class PartialSerializationTestLanguageCompletionContributor extends AbstractPartialSerializationTestLanguageCompletionContributor {
  public PartialSerializationTestLanguageCompletionContributor() {
    this(PartialSerializationTestLanguageLanguage.INSTANCE);
  }
  
  public PartialSerializationTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
