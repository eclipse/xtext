package org.eclipse.xtext.testlanguages.idea.lang;

import org.eclipse.xtext.testlanguages.idea.lang.AbstractActionTestLanguage2FileType;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;

@SuppressWarnings("all")
public class ActionTestLanguage2FileType extends AbstractActionTestLanguage2FileType {
  public final static ActionTestLanguage2FileType INSTANCE = new ActionTestLanguage2FileType();
  
  public ActionTestLanguage2FileType() {
    super(ActionTestLanguage2Language.INSTANCE);
  }
}
