package org.eclipse.xtext.parser.fragments.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.fragments.idea.completion.AbstractFragmentTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

@SuppressWarnings("all")
public class FragmentTestLanguageCompletionContributor extends AbstractFragmentTestLanguageCompletionContributor {
  public FragmentTestLanguageCompletionContributor() {
    this(FragmentTestLanguageLanguage.INSTANCE);
  }
  
  public FragmentTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
