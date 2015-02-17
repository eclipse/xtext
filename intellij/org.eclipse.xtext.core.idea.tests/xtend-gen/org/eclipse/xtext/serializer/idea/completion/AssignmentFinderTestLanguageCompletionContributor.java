package org.eclipse.xtext.serializer.idea.completion;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.serializer.idea.completion.AbstractAssignmentFinderTestLanguageCompletionContributor;
import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage;

@SuppressWarnings("all")
public class AssignmentFinderTestLanguageCompletionContributor extends AbstractAssignmentFinderTestLanguageCompletionContributor {
  public AssignmentFinderTestLanguageCompletionContributor() {
    this(AssignmentFinderTestLanguageLanguage.INSTANCE);
  }
  
  public AssignmentFinderTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
