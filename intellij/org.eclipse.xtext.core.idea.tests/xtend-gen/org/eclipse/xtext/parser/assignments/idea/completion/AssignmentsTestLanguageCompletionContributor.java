package org.eclipse.xtext.parser.assignments.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.parser.assignments.idea.completion.AbstractAssignmentsTestLanguageCompletionContributor;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;

@SuppressWarnings("all")
public class AssignmentsTestLanguageCompletionContributor extends AbstractAssignmentsTestLanguageCompletionContributor {
  public AssignmentsTestLanguageCompletionContributor() {
    this(AssignmentsTestLanguageLanguage.INSTANCE);
  }
  
  public AssignmentsTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
