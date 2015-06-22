package org.eclipse.xtext.parser.antlr.idea;

import com.google.inject.Injector;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;
import org.eclipse.xtext.parser.antlr.idea.Bug301935ExTestLanguageStandaloneSetupIdea;

@SuppressWarnings("all")
public class Bug301935ExTestLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      Bug301935ExTestLanguageStandaloneSetupIdea _bug301935ExTestLanguageStandaloneSetupIdea = new Bug301935ExTestLanguageStandaloneSetupIdea();
      _xblockexpression = _bug301935ExTestLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
