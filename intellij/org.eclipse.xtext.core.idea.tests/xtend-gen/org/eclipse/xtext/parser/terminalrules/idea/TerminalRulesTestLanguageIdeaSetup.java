package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.TerminalRulesTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class TerminalRulesTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      TerminalRulesTestLanguageStandaloneSetupIdea _terminalRulesTestLanguageStandaloneSetupIdea = new TerminalRulesTestLanguageStandaloneSetupIdea();
      _xblockexpression = _terminalRulesTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
