package org.eclipse.xtend.core.completion;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;

@SuppressWarnings("all")
public class XtendCompletionContributor extends AbstractCompletionContributor {
  public XtendCompletionContributor() {
    super(XtendLanguage.INSTANCE);
  }
}
