package org.eclipse.xtext.idea.completion;

import org.eclipse.xtext.idea.completion.AbstractXtextCompletionContributor;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.lang.XtextLanguage;

@SuppressWarnings("all")
public class XtextCompletionContributor extends AbstractXtextCompletionContributor {
  public XtextCompletionContributor() {
    this(XtextLanguage.INSTANCE);
  }
  
  public XtextCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
