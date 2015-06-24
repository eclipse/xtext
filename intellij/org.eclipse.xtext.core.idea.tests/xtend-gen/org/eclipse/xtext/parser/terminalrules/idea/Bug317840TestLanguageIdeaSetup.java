package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.Bug317840TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug317840TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug317840TestLanguageStandaloneSetupIdea _bug317840TestLanguageStandaloneSetupIdea = new Bug317840TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug317840TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
