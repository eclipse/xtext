package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.AbstractSimpleUnorderedGroupsTestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;

@SuppressWarnings("all")
public class SimpleUnorderedGroupsTestLanguageFileType extends AbstractSimpleUnorderedGroupsTestLanguageFileType {
  public final static SimpleUnorderedGroupsTestLanguageFileType INSTANCE = new SimpleUnorderedGroupsTestLanguageFileType();
  
  public SimpleUnorderedGroupsTestLanguageFileType() {
    super(SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE);
  }
}
