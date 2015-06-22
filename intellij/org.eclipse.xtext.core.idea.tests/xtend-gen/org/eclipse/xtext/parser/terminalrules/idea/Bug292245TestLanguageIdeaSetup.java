package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.Bug292245TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug292245TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug292245TestLanguageStandaloneSetupIdea _bug292245TestLanguageStandaloneSetupIdea = new Bug292245TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug292245TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
