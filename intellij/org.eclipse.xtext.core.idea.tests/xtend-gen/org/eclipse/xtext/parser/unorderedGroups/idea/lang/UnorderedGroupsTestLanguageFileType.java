package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.AbstractUnorderedGroupsTestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage;

@SuppressWarnings("all")
public class UnorderedGroupsTestLanguageFileType extends AbstractUnorderedGroupsTestLanguageFileType {
  public final static UnorderedGroupsTestLanguageFileType INSTANCE = new UnorderedGroupsTestLanguageFileType();
  
  public UnorderedGroupsTestLanguageFileType() {
    super(UnorderedGroupsTestLanguageLanguage.INSTANCE);
  }
}
