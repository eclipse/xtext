package org.eclipse.xtext.parser.parameters.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.parameters.idea.NoParametersTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class NoParametersTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      NoParametersTestLanguageStandaloneSetupIdea _noParametersTestLanguageStandaloneSetupIdea = new NoParametersTestLanguageStandaloneSetupIdea();
      _xblockexpression = _noParametersTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
