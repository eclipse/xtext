package org.eclipse.xtext.metamodelreferencing.tests.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.idea.completion.AbstractEcoreReferenceTestLanguageCompletionContributor;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

@SuppressWarnings("all")
public class EcoreReferenceTestLanguageCompletionContributor extends AbstractEcoreReferenceTestLanguageCompletionContributor {
  public EcoreReferenceTestLanguageCompletionContributor() {
    this(EcoreReferenceTestLanguageLanguage.INSTANCE);
  }
  
  public EcoreReferenceTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
