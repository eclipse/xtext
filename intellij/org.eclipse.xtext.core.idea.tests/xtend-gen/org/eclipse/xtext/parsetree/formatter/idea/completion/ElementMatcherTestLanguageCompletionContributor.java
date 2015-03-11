package org.eclipse.xtext.parsetree.formatter.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.formatter.idea.completion.AbstractElementMatcherTestLanguageCompletionContributor;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;

@SuppressWarnings("all")
public class ElementMatcherTestLanguageCompletionContributor extends AbstractElementMatcherTestLanguageCompletionContributor {
  public ElementMatcherTestLanguageCompletionContributor() {
    this(ElementMatcherTestLanguageLanguage.INSTANCE);
  }
  
  public ElementMatcherTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
