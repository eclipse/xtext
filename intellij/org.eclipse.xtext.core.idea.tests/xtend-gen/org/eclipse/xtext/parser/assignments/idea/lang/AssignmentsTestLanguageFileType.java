package org.eclipse.xtext.parser.assignments.idea.lang;

import org.eclipse.xtext.parser.assignments.idea.lang.AbstractAssignmentsTestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;

@SuppressWarnings("all")
public class AssignmentsTestLanguageFileType extends AbstractAssignmentsTestLanguageFileType {
  public final static AssignmentsTestLanguageFileType INSTANCE = new AssignmentsTestLanguageFileType();
  
  public AssignmentsTestLanguageFileType() {
    super(AssignmentsTestLanguageLanguage.INSTANCE);
  }
}
