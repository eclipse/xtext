package org.eclipse.xtext.parser.assignments.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.assignments.idea.Bug287184TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug287184TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug287184TestLanguageStandaloneSetupIdea _bug287184TestLanguageStandaloneSetupIdea = new Bug287184TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug287184TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
