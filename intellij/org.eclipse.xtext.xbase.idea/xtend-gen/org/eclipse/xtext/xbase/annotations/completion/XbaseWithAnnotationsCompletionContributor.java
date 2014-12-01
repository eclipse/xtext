package org.eclipse.xtext.xbase.annotations.completion;

import org.eclipse.xtext.idea.completion.AbstractCompletionContributor;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

@SuppressWarnings("all")
public class XbaseWithAnnotationsCompletionContributor extends AbstractCompletionContributor {
  public XbaseWithAnnotationsCompletionContributor() {
    super(XbaseWithAnnotationsLanguage.INSTANCE);
  }
}
