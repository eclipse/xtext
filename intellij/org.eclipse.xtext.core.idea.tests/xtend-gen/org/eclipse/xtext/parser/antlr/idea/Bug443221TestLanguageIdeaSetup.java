package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug443221TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug443221TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug443221TestLanguageStandaloneSetupIdea _bug443221TestLanguageStandaloneSetupIdea = new Bug443221TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug443221TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
