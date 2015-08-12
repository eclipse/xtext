package org.eclipse.xtext.parser.parameters.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.parameters.idea.ParametersTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class ParametersTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      ParametersTestLanguageStandaloneSetupIdea _parametersTestLanguageStandaloneSetupIdea = new ParametersTestLanguageStandaloneSetupIdea();
      _xblockexpression = _parametersTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
