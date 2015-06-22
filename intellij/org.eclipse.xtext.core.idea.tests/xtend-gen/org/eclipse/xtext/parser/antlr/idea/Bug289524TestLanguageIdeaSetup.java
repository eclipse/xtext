package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug289524TestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug289524TestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug289524TestLanguageStandaloneSetupIdea _bug289524TestLanguageStandaloneSetupIdea = new Bug289524TestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug289524TestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
