package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractActionTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage;

@SuppressWarnings("all")
public class ActionTestLanguageFileType extends AbstractActionTestLanguageFileType {
  public final static ActionTestLanguageFileType INSTANCE = new ActionTestLanguageFileType();
  
  public ActionTestLanguageFileType() {
    super(ActionTestLanguageLanguage.INSTANCE);
  }
}
