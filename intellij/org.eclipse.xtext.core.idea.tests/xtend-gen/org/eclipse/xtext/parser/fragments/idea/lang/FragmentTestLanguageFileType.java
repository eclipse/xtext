package org.eclipse.xtext.parser.fragments.idea.lang;

import org.eclipse.xtext.parser.fragments.idea.lang.AbstractFragmentTestLanguageFileType;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

@SuppressWarnings("all")
public class FragmentTestLanguageFileType extends AbstractFragmentTestLanguageFileType {
  public final static FragmentTestLanguageFileType INSTANCE = new FragmentTestLanguageFileType();
  
  public FragmentTestLanguageFileType() {
    super(FragmentTestLanguageLanguage.INSTANCE);
  }
}
