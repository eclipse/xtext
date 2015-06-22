package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.AbstractMetamodelRefTestLanguageFileType;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

@SuppressWarnings("all")
public class MetamodelRefTestLanguageFileType extends AbstractMetamodelRefTestLanguageFileType {
  public final static MetamodelRefTestLanguageFileType INSTANCE = new MetamodelRefTestLanguageFileType();
  
  public MetamodelRefTestLanguageFileType() {
    super(MetamodelRefTestLanguageLanguage.INSTANCE);
  }
}
