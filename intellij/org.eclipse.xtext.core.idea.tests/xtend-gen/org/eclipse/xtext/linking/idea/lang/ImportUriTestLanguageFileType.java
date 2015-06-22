package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractImportUriTestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage;

@SuppressWarnings("all")
public class ImportUriTestLanguageFileType extends AbstractImportUriTestLanguageFileType {
  public final static ImportUriTestLanguageFileType INSTANCE = new ImportUriTestLanguageFileType();
  
  public ImportUriTestLanguageFileType() {
    super(ImportUriTestLanguageLanguage.INSTANCE);
  }
}
