package org.eclipse.xtext.xbase.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.idea.completion.AbstractXbaseCompletionContributor;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

@SuppressWarnings("all")
public class XbaseCompletionContributor extends AbstractXbaseCompletionContributor {
  public XbaseCompletionContributor() {
    this(XbaseLanguage.INSTANCE);
  }
  
  public XbaseCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
