package org.eclipse.xtext.linking.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.linking.idea.completion.AbstractImportUriTestLanguageCompletionContributor;
import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage;

@SuppressWarnings("all")
public class ImportUriTestLanguageCompletionContributor extends AbstractImportUriTestLanguageCompletionContributor {
  public ImportUriTestLanguageCompletionContributor() {
    this(ImportUriTestLanguageLanguage.INSTANCE);
  }
  
  public ImportUriTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
