package org.eclipse.xtend.core.idea.completion;

import org.eclipse.xtend.core.idea.completion.AbstractXtendCompletionContributor;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class XtendCompletionContributor extends AbstractXtendCompletionContributor {
  public XtendCompletionContributor() {
    this(XtendLanguage.INSTANCE);
  }
  
  public XtendCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
