package org.eclipse.xtext.purexbase.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.purexbase.idea.completion.AbstractPureXbaseCompletionContributor;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

@SuppressWarnings("all")
public class PureXbaseCompletionContributor extends AbstractPureXbaseCompletionContributor {
  public PureXbaseCompletionContributor() {
    this(PureXbaseLanguage.INSTANCE);
  }
  
  public PureXbaseCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
