package org.eclipse.xtext.parser.parameters.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.parameters.idea.TwoParametersTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class TwoParametersTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      TwoParametersTestLanguageStandaloneSetupIdea _twoParametersTestLanguageStandaloneSetupIdea = new TwoParametersTestLanguageStandaloneSetupIdea();
      _xblockexpression = _twoParametersTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
