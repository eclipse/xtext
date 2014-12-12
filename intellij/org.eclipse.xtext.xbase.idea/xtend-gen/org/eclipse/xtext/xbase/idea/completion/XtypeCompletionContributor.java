package org.eclipse.xtext.xbase.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.idea.completion.AbstractXtypeCompletionContributor;
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

@SuppressWarnings("all")
public class XtypeCompletionContributor extends AbstractXtypeCompletionContributor {
  public XtypeCompletionContributor() {
    this(XtypeLanguage.INSTANCE);
  }
  
  public XtypeCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
