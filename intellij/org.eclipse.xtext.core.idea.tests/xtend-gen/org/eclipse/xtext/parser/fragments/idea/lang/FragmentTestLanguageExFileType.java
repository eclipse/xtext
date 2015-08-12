package org.eclipse.xtext.parser.fragments.idea.lang;

import org.eclipse.xtext.parser.fragments.idea.lang.AbstractFragmentTestLanguageExFileType;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;

@SuppressWarnings("all")
public class FragmentTestLanguageExFileType extends AbstractFragmentTestLanguageExFileType {
  public final static FragmentTestLanguageExFileType INSTANCE = new FragmentTestLanguageExFileType();
  
  public FragmentTestLanguageExFileType() {
    super(FragmentTestLanguageExLanguage.INSTANCE);
  }
}
