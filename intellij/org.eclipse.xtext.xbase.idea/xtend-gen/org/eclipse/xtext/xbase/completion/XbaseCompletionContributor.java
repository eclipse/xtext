package org.eclipse.xtext.xbase.completion;

import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

@SuppressWarnings("all")
public class XbaseCompletionContributor extends AbstractCompletionContributor {
  public XbaseCompletionContributor() {
    super(XbaseLanguage.INSTANCE);
  }
}
