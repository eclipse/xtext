package org.eclipse.xtext.parser.assignments.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.assignments.idea.Bug288432TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug288432TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug288432TestLanguageStandaloneSetupIdea _bug288432TestLanguageStandaloneSetupIdea = new Bug288432TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug288432TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
