package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.AbstractExUnorderedGroupsTestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;

@SuppressWarnings("all")
public class ExUnorderedGroupsTestLanguageFileType extends AbstractExUnorderedGroupsTestLanguageFileType {
  public final static ExUnorderedGroupsTestLanguageFileType INSTANCE = new ExUnorderedGroupsTestLanguageFileType();
  
  public ExUnorderedGroupsTestLanguageFileType() {
    super(ExUnorderedGroupsTestLanguageLanguage.INSTANCE);
  }
}
