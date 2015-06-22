package org.eclipse.xtext.parser.terminalrules.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.terminalrules.idea.XtextTerminalsTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class XtextTerminalsTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      XtextTerminalsTestLanguageStandaloneSetupIdea _xtextTerminalsTestLanguageStandaloneSetupIdea = new XtextTerminalsTestLanguageStandaloneSetupIdea();
      _xblockexpression = _xtextTerminalsTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
