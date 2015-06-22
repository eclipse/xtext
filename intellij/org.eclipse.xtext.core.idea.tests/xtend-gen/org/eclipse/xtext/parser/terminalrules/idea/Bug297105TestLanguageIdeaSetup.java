package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.Bug297105TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug297105TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug297105TestLanguageStandaloneSetupIdea _bug297105TestLanguageStandaloneSetupIdea = new Bug297105TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug297105TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
