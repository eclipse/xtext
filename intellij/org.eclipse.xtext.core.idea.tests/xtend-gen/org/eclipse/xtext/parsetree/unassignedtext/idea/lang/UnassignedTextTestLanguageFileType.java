package org.eclipse.xtext.parsetree.unassignedtext.idea.lang;

import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.AbstractUnassignedTextTestLanguageFileType;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;

@SuppressWarnings("all")
public class UnassignedTextTestLanguageFileType extends AbstractUnassignedTextTestLanguageFileType {
  public final static UnassignedTextTestLanguageFileType INSTANCE = new UnassignedTextTestLanguageFileType();
  
  public UnassignedTextTestLanguageFileType() {
    super(UnassignedTextTestLanguageLanguage.INSTANCE);
  }
}
