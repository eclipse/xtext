package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.HiddenTerminalsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class HiddenTerminalsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      HiddenTerminalsTestLanguageStandaloneSetupIdea _hiddenTerminalsTestLanguageStandaloneSetupIdea = new HiddenTerminalsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _hiddenTerminalsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
