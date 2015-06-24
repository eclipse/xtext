package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug296889ExTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug296889ExTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug296889ExTestLanguageStandaloneSetupIdea _bug296889ExTestLanguageStandaloneSetupIdea = new Bug296889ExTestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug296889ExTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
