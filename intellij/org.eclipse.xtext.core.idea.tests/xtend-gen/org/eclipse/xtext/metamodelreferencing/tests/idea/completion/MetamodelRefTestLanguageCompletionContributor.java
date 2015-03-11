package org.eclipse.xtext.metamodelreferencing.tests.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.idea.completion.AbstractMetamodelRefTestLanguageCompletionContributor;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

@SuppressWarnings("all")
public class MetamodelRefTestLanguageCompletionContributor extends AbstractMetamodelRefTestLanguageCompletionContributor {
  public MetamodelRefTestLanguageCompletionContributor() {
    this(MetamodelRefTestLanguageLanguage.INSTANCE);
  }
  
  public MetamodelRefTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
