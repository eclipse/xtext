package org.eclipse.xtext.serializer.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.serializer.idea.AssignmentFinderTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class AssignmentFinderTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      AssignmentFinderTestLanguageStandaloneSetupIdea _assignmentFinderTestLanguageStandaloneSetupIdea = new AssignmentFinderTestLanguageStandaloneSetupIdea();
      _xblockexpression = _assignmentFinderTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
