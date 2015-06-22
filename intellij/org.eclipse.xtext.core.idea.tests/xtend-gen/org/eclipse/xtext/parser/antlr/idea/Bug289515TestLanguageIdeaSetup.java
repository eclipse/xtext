package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug289515TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug289515TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug289515TestLanguageStandaloneSetupIdea _bug289515TestLanguageStandaloneSetupIdea = new Bug289515TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug289515TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
