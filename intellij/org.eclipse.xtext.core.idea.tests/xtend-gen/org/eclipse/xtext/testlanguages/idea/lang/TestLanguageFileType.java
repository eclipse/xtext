package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

@SuppressWarnings("all")
public class TestLanguageFileType extends AbstractTestLanguageFileType {
  public final static TestLanguageFileType INSTANCE = new TestLanguageFileType();
  
  public TestLanguageFileType() {
    super(TestLanguageLanguage.INSTANCE);
  }
}
