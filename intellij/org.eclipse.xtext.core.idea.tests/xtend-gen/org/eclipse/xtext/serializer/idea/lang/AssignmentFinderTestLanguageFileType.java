package org.eclipse.xtext.serializer.idea.lang;

import org.eclipse.xtext.serializer.idea.lang.AbstractAssignmentFinderTestLanguageFileType;
import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage;

@SuppressWarnings("all")
public class AssignmentFinderTestLanguageFileType extends AbstractAssignmentFinderTestLanguageFileType {
  public final static AssignmentFinderTestLanguageFileType INSTANCE = new AssignmentFinderTestLanguageFileType();
  
  public AssignmentFinderTestLanguageFileType() {
    super(AssignmentFinderTestLanguageLanguage.INSTANCE);
  }
}
