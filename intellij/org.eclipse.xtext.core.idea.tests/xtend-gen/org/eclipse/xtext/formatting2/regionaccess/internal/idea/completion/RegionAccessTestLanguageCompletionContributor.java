package org.eclipse.xtext.formatting2.regionaccess.internal.idea.completion;

import org.eclipse.xtext.formatting2.regionaccess.internal.idea.completion.AbstractRegionAccessTestLanguageCompletionContributor;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class RegionAccessTestLanguageCompletionContributor extends AbstractRegionAccessTestLanguageCompletionContributor {
  public RegionAccessTestLanguageCompletionContributor() {
    this(RegionAccessTestLanguageLanguage.INSTANCE);
  }
  
  public RegionAccessTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
