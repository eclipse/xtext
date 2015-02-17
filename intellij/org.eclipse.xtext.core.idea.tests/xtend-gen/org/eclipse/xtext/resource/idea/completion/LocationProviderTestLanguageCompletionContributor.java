package org.eclipse.xtext.resource.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.resource.idea.completion.AbstractLocationProviderTestLanguageCompletionContributor;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;

@SuppressWarnings("all")
public class LocationProviderTestLanguageCompletionContributor extends AbstractLocationProviderTestLanguageCompletionContributor {
  public LocationProviderTestLanguageCompletionContributor() {
    this(LocationProviderTestLanguageLanguage.INSTANCE);
  }
  
  public LocationProviderTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
