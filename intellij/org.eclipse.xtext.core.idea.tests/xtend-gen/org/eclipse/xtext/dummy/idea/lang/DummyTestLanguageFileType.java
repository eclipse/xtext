package org.eclipse.xtext.dummy.idea.lang;

import org.eclipse.xtext.dummy.idea.lang.AbstractDummyTestLanguageFileType;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;

@SuppressWarnings("all")
public class DummyTestLanguageFileType extends AbstractDummyTestLanguageFileType {
  public final static DummyTestLanguageFileType INSTANCE = new DummyTestLanguageFileType();
  
  public DummyTestLanguageFileType() {
    super(DummyTestLanguageLanguage.INSTANCE);
  }
}
