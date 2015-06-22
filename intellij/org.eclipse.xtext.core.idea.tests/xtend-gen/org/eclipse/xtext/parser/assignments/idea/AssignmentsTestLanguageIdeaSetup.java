package org.eclipse.xtext.parser.assignments.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.assignments.idea.AssignmentsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class AssignmentsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      AssignmentsTestLanguageStandaloneSetupIdea _assignmentsTestLanguageStandaloneSetupIdea = new AssignmentsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _assignmentsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
