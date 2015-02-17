package org.eclipse.xtext.parsetree.transientvalues.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parsetree.transientvalues.idea.completion.AbstractTransientValuesTestCompletionContributor;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

@SuppressWarnings("all")
public class TransientValuesTestCompletionContributor extends AbstractTransientValuesTestCompletionContributor {
  public TransientValuesTestCompletionContributor() {
    this(TransientValuesTestLanguage.INSTANCE);
  }
  
  public TransientValuesTestCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
