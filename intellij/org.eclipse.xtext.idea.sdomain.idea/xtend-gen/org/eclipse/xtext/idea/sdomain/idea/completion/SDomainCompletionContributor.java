package org.eclipse.xtext.idea.sdomain.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.idea.sdomain.idea.completion.AbstractSDomainCompletionContributor;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

@SuppressWarnings("all")
public class SDomainCompletionContributor extends AbstractSDomainCompletionContributor {
  public SDomainCompletionContributor() {
    this(SDomainLanguage.INSTANCE);
  }
  
  public SDomainCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
