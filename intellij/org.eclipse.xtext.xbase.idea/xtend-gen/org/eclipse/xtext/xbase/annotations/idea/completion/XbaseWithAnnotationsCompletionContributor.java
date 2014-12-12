package org.eclipse.xtext.xbase.annotations.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.xbase.annotations.idea.completion.AbstractXbaseWithAnnotationsCompletionContributor;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

@SuppressWarnings("all")
public class XbaseWithAnnotationsCompletionContributor extends AbstractXbaseWithAnnotationsCompletionContributor {
  public XbaseWithAnnotationsCompletionContributor() {
    this(XbaseWithAnnotationsLanguage.INSTANCE);
  }
  
  public XbaseWithAnnotationsCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
