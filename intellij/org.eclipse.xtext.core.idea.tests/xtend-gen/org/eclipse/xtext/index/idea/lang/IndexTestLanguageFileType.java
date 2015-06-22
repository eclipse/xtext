package org.eclipse.xtext.index.idea.lang;

import org.eclipse.xtext.index.idea.lang.AbstractIndexTestLanguageFileType;
import org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage;

@SuppressWarnings("all")
public class IndexTestLanguageFileType extends AbstractIndexTestLanguageFileType {
  public final static IndexTestLanguageFileType INSTANCE = new IndexTestLanguageFileType();
  
  public IndexTestLanguageFileType() {
    super(IndexTestLanguageLanguage.INSTANCE);
  }
}
