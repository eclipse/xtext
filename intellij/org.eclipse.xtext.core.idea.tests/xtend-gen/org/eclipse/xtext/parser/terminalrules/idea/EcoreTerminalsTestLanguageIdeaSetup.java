package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.EcoreTerminalsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class EcoreTerminalsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      EcoreTerminalsTestLanguageStandaloneSetupIdea _ecoreTerminalsTestLanguageStandaloneSetupIdea = new EcoreTerminalsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _ecoreTerminalsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
