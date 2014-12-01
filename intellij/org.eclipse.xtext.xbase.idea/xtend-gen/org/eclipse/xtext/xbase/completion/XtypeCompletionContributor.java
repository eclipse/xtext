package org.eclipse.xtext.xbase.completion;

import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

@SuppressWarnings("all")
public class XtypeCompletionContributor extends AbstractCompletionContributor {
  public XtypeCompletionContributor() {
    super(XtypeLanguage.INSTANCE);
  }
}
