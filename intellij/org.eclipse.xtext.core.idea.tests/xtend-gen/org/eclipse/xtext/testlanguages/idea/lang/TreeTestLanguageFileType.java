package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractTreeTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

@SuppressWarnings("all")
public class TreeTestLanguageFileType extends AbstractTreeTestLanguageFileType {
  public final static TreeTestLanguageFileType INSTANCE = new TreeTestLanguageFileType();
  
  public TreeTestLanguageFileType() {
    super(TreeTestLanguageLanguage.INSTANCE);
  }
}
