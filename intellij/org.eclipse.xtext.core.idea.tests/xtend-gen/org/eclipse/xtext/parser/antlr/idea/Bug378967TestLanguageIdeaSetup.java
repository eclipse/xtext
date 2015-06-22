package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug378967TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug378967TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug378967TestLanguageStandaloneSetupIdea _bug378967TestLanguageStandaloneSetupIdea = new Bug378967TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug378967TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
