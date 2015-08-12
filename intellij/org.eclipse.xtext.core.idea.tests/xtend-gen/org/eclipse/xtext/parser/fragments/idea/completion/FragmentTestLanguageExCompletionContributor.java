package org.eclipse.xtext.parser.fragments.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.fragments.idea.completion.AbstractFragmentTestLanguageExCompletionContributor;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;

@SuppressWarnings("all")
public class FragmentTestLanguageExCompletionContributor extends AbstractFragmentTestLanguageExCompletionContributor {
  public FragmentTestLanguageExCompletionContributor() {
    this(FragmentTestLanguageExLanguage.INSTANCE);
  }
  
  public FragmentTestLanguageExCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
