package org.eclipse.xtext.enumrules.idea.completion;

import org.eclipse.xtext.enumrules.idea.completion.AbstractEnumAndReferenceTestLanguageCompletionContributor;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class EnumAndReferenceTestLanguageCompletionContributor extends AbstractEnumAndReferenceTestLanguageCompletionContributor {
  public EnumAndReferenceTestLanguageCompletionContributor() {
    this(EnumAndReferenceTestLanguageLanguage.INSTANCE);
  }
  
  public EnumAndReferenceTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
