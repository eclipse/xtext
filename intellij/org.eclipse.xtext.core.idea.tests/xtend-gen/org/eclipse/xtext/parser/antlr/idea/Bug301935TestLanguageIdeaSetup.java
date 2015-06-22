package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug301935TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug301935TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug301935TestLanguageStandaloneSetupIdea _bug301935TestLanguageStandaloneSetupIdea = new Bug301935TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug301935TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
