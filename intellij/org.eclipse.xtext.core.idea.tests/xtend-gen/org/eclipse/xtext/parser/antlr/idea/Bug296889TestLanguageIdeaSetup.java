package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug296889TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug296889TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug296889TestLanguageStandaloneSetupIdea _bug296889TestLanguageStandaloneSetupIdea = new Bug296889TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug296889TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
